package com.it.personaldashboard.services.budgeting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.it.personaldashboard.dto.budgeting.BgtCategoryDTO;
import com.it.personaldashboard.dto.budgeting.BgtPeriodAmountForm;
import com.it.personaldashboard.dto.budgeting.BgtSubCategoryAmountForm;
import com.it.personaldashboard.dto.budgeting.BgtSubCategoryDTO;
import com.it.personaldashboard.dto.budgeting.view.BgtNatureTree;
import com.it.personaldashboard.jpa.budgeting.BgtPeriodAmountDao;
import com.it.personaldashboard.jpa.budgeting.BgtPeriodDao;
import com.it.personaldashboard.jpa.budgeting.BgtSubCategoryDao;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity;
import com.it.personaldashboard.model.budgeting.BgtPeriodAmountEntity;
import com.it.personaldashboard.model.budgeting.BgtPeriodEntity;
import com.it.personaldashboard.model.budgeting.BgtSubCategoryEntity;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity.Nature;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BgtPeriodAmountService {

    @Autowired
    private BgtPeriodDao bgtPeriodDao;

    @Autowired
    private BgtPeriodAmountDao bgtPeriodAmountDao;

    @Autowired
    private BgtSubCategoryDao bgtSubCategoryDao;

    public BgtPeriodAmountForm save(BgtPeriodAmountForm form) {
        
        // recupero del periodo, se censito
        BgtPeriodEntity periodEntity = new BgtPeriodEntity(form.period().month(), form.period().year());
        Optional<BgtPeriodEntity> optPeriod = bgtPeriodDao.findOne(Example.of(periodEntity));
        // se non esiste -> errore
        if(optPeriod.isEmpty()) {
            throw new IllegalArgumentException("Impossibile salvare i valori richiesti, il periodo da associare non esiste.");
        }

        // PERIODO SU CUI CENSIRE I VALORI
        periodEntity = optPeriod.get();

        // controllo che non esistano gia valori associati a quel periodo
        BgtPeriodAmountEntity periodAmountEntity = new BgtPeriodAmountEntity();
        periodAmountEntity.setPeriod(periodEntity);
        // se esistono elementi in BgtPeriodAmountEntity per quel periodo -> errore
        boolean alreadyExistAmounts = bgtPeriodAmountDao.exists(Example.of(periodAmountEntity));
        if(alreadyExistAmounts) {
            throw new IllegalArgumentException("Impossibile salvare i valori richiesti, esistono gia' elementi per il periodo richiesto.");
        }

        // recupero di tutte le subcategories
        List<BgtSubCategoryEntity> lstAllSubcategories = bgtSubCategoryDao.findAll();

        // LISTA DI ELEMENTI DA SALVARE
        List<BgtPeriodAmountEntity> lstPeriodAmount = new ArrayList<>();
        for(BgtSubCategoryAmountForm subCategoryAmountForm : form.lstSubCategoryAmount()) {
            
            // recupero della subcategory per "nome"
            String subCategoryName = subCategoryAmountForm.subcategory().name();
            Optional<BgtSubCategoryEntity> optSubCategory = lstAllSubcategories
                .stream()
                .filter(sb->subCategoryName.equalsIgnoreCase(sb.getName()))
                .findFirst();

            if(optSubCategory.isEmpty()) {
                throw new IllegalArgumentException(String.format(
                    "Impossibile salvare i valori richiesti, non esiste una sottocategoria con nome: %s.",
                    subCategoryName
                ));
            }

            BgtPeriodAmountEntity entity = new BgtPeriodAmountEntity();
            entity.setAmount(subCategoryAmountForm.amount());
            entity.setSubCategory(optSubCategory.get());
            entity.setPeriod(periodEntity);
            lstPeriodAmount.add(entity);

        }

        bgtPeriodAmountDao.saveAll(lstPeriodAmount);

        return form;
        
    }
    

    /**
     * Esporta la lista delle natura
     *  -> lista delle categorie per ogni natura
     *      -> lista delle sottocategorie per ogni natura
     * 
     * 
     * @return
     */
    public List<BgtNatureTree> prepareNatureTreeView() {

        List<BgtNatureTree> listOutput = new ArrayList<>();

        for(Nature nature : BgtCategoryEntity.Nature.values()) {

            // lista delle sottocategorie per natura
            BgtSubCategoryEntity subCategoryFilter = new BgtSubCategoryEntity();
            subCategoryFilter.setCategory(new BgtCategoryEntity(null, nature));
            List<BgtSubCategoryEntity> listSubCategoriesByNature = bgtSubCategoryDao.findAll(Example.of(subCategoryFilter));

            // per ognuna estraggo una mappa CATEGORIA-list(SUB_CATEGORIE)
            List<BgtCategoryDTO> categories = new ArrayList<>();
            TreeMap<String, List<BgtSubCategoryDTO>> mapCategories = new TreeMap<>();
            for(BgtSubCategoryEntity subCategory : listSubCategoriesByNature){

                String categoryId = subCategory.getCategory().getId().toString();

                BgtCategoryDTO categoryDTO = new BgtCategoryDTO(
                    categoryId, 
                    subCategory.getCategory().getName(), 
                    nature.name(), 
                    new ArrayList<>());

                BgtSubCategoryDTO dto = new BgtSubCategoryDTO(subCategory.getId().toString(), subCategory.getName());

                if(mapCategories.containsKey(categoryId)) {
                    mapCategories.get(categoryId).add(dto);
                    continue;
                }

                List<BgtSubCategoryDTO> newList = new ArrayList<>();
                newList.add(dto);
                mapCategories.put(categoryId, newList);
                categories.add(categoryDTO);

            }
            
            // trasferisco l'aggregazione in un oggetto maggiormente leggibile
            // uso la mappa perche piu veloce di una normale lista
            for(BgtCategoryDTO categoryDTO : categories) {
                List<BgtSubCategoryDTO> subCategoriesList = mapCategories.get(categoryDTO.id());
                subCategoriesList = subCategoriesList != null ? subCategoriesList : List.of();
                categoryDTO.listSubCategories().addAll(subCategoriesList);
            }
            
            categories.sort(Comparator.comparing(BgtCategoryDTO::name));

            listOutput.add(new BgtNatureTree(nature.name(), Nature.getLabel(nature.name()), categories));

        }

        listOutput.sort(Comparator.comparing(BgtNatureTree::nature));

        return listOutput;

    }

}
