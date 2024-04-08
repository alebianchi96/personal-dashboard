package com.it.personaldashboard.services.budgeting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.personaldashboard.dto.budgeting.view.BgtViewMonthYearDTO;
import com.it.personaldashboard.dto.budgeting.view.BgtViewTotalMonthYearNatureDTO;
import com.it.personaldashboard.dto.budgeting.view.BgtViewTotalYearCategoryDTO;
import com.it.personaldashboard.dto.budgeting.view.BgtViewTotalYearNatureDTO;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewBudgetsTotalDao;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewNumberPeriodsYearDao;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewTotalMonthYearCategoryDao;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewTotalMonthYearNatureDao;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewTotalYearCategoryDao;
import com.it.personaldashboard.jpa.budgeting.view.BgtViewTotalYearNatureDao;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity.Nature;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalMonthYearNatureEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearCategoryEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearNatureEntity;
import com.it.personaldashboard.utils.DateUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BgtViewService {

    @Autowired
    private BgtViewBudgetsTotalDao bgtViewBudgetsTotalDao;

    @Autowired
    private BgtViewNumberPeriodsYearDao bgtViewNumberPeriodsYearDao;
    
    @Autowired
    private BgtViewTotalMonthYearCategoryDao bgtViewTotalMonthYearCategoryDao;
    
    @Autowired
    private BgtViewTotalMonthYearNatureDao bgtViewTotalMonthYearNatureDao;
    
    @Autowired
    private BgtViewTotalYearCategoryDao bgtViewTotalYearCategoryDao;
    
    @Autowired
    private BgtViewTotalYearNatureDao bgtViewTotalYearNatureDao;

    public void test() {
        // System.out.println(bgtViewBudgetsTotalDao.findAll());
        // System.out.println(bgtViewNumberPeriodsYearDao.findAll());
        // System.out.println(bgtViewTotalMonthYearCategoryDao.findAll());
        // System.out.println(bgtViewTotalMonthYearNatureDao.findAll());
        // System.out.println(bgtViewTotalYearCategoryDao.findAll());
        // System.out.println(bgtViewTotalYearNatureDao.findAll());
    }

    
    public List<BgtViewMonthYearDTO> listTotalMonthYearNatureByYear(Integer year) { 
        //BgtViewTotalMonthYearNatureDao
        List<BgtViewTotalMonthYearNatureEntity> lst = bgtViewTotalMonthYearNatureDao
            .findAllTotalMonthYearNatureByYear(year);
        lst = lst != null ? lst : List.of(); 
        
        // lavoro il risultato della query per ottenere un oggetto ordinabile
        List<BgtViewTotalMonthYearNatureDTO> listDTO = new ArrayList<>(); 
        for(BgtViewTotalMonthYearNatureEntity e : lst){
            listDTO.add(new BgtViewTotalMonthYearNatureDTO(
                DateUtils.getIndexByMonth(e.getMonth()), 
                e.getMonth(), 
                year, 
                e.getNature(), 
                e.getAmount()));
        }
        listDTO.sort(Comparator.comparing(BgtViewTotalMonthYearNatureDTO::indexMonth)
            .thenComparing(BgtViewTotalMonthYearNatureDTO::nature));

        // wrap della lista raggruppando per mese
        List<BgtViewMonthYearDTO> listWrapper = this.initMonthYearList(year);
        for(BgtViewTotalMonthYearNatureDTO dto : listDTO) {
            Optional<BgtViewMonthYearDTO> wrp = listWrapper.stream()
                .filter(w->w.indexMonth().equals(dto.indexMonth()))
                .findFirst();
            if(wrp.isEmpty()) { continue; }
            wrp.get().listNatureAmount().add(dto);
        }

        listWrapper = this.cleanFromVoidListNatureAmount(listWrapper);

        listWrapper = this.addTotalForEachMonth(listWrapper);

        return listWrapper; 

    }


    private List<BgtViewMonthYearDTO> addTotalForEachMonth(List<BgtViewMonthYearDTO> lst) {
        for(BgtViewMonthYearDTO dto : lst) {
            Integer indexMonth = 1;
            String month = "";
            Integer year = 1;
            String nature = "TOTAL";
            BigDecimal total = BigDecimal.ZERO;
            for(BgtViewTotalMonthYearNatureDTO r : dto.listNatureAmount()) {
                indexMonth = r.indexMonth();
                month = r.month();
                year = r.year();
                total = addByNature(total, r.amount(), r.nature());
            }
            dto.listNatureAmount().add(new BgtViewTotalMonthYearNatureDTO(indexMonth, month, year, nature, total));
        }
        return lst;
    }


    private List<BgtViewMonthYearDTO> cleanFromVoidListNatureAmount(List<BgtViewMonthYearDTO> lst) {
        return lst.stream().filter(w->!w.listNatureAmount().isEmpty()).toList();
    }


    private List<BgtViewMonthYearDTO> initMonthYearList(Integer year) {
        List<BgtViewMonthYearDTO> lst = new ArrayList<>();
        lst.add(new BgtViewMonthYearDTO(1, "Gennaio", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(2, "Febbraio", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(3, "Marzo", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(4, "Aprile", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(5, "Maggio", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(6, "Giugno", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(7, "Luglio", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(8, "Agosto", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(9, "Settembre", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(10, "Ottobre", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(11, "Novembre", year, new ArrayList<>()));
        lst.add(new BgtViewMonthYearDTO(12, "Dicembre", year, new ArrayList<>()));
        return lst;
    }


    public List<BgtViewTotalYearNatureDTO> totalYearNatureByYear(Integer year) { 
        // BgtViewTotalYearNatureDao
        List<BgtViewTotalYearNatureEntity> lst = bgtViewTotalYearNatureDao
            .findAllTotalYearNatureByYear(year);
        lst = lst != null ? lst : List.of(); 

        List<BgtViewTotalYearNatureDTO> listDTO = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;
        for(BgtViewTotalYearNatureEntity e : lst){
            total = addByNature(total, e.getAmount(), e.getNature());
            listDTO.add(new BgtViewTotalYearNatureDTO(year, e.getNature(), e.getAmount()));
        }

        listDTO.add(new BgtViewTotalYearNatureDTO(year, "TOTAL", total));

        listDTO.sort(Comparator.comparing(BgtViewTotalYearNatureDTO::nature));

        return listDTO; 
    }


    private BigDecimal addByNature(BigDecimal total, BigDecimal valueToAdd, String nature) {
        valueToAdd = valueToAdd.multiply(BigDecimal.valueOf(-1));
        if(Nature.REVENUES.name().equalsIgnoreCase(nature)) {
            valueToAdd = valueToAdd.multiply(BigDecimal.valueOf(-1));
        }
        return total.add(valueToAdd);
    }


    public List<BgtViewTotalYearCategoryDTO> listTotalYearCategoryByNatureAndYear(Nature nature, Integer year) { 
        // BgtViewTotalMonthYearCategoryDao
        List<BgtViewTotalYearCategoryEntity> lst = bgtViewTotalYearCategoryDao
            .findAllTotalYearCategoryByNatureAndYear(nature.name(), year);
        lst = lst != null ? lst : List.of(); 
        
        List<BgtViewTotalYearCategoryDTO> listDTO = new ArrayList<>();

        for(BgtViewTotalYearCategoryEntity e : lst){
            listDTO.add(new BgtViewTotalYearCategoryDTO(
                year, 
                e.getNature(), 
                e.getCategory(), 
                e.getAmountRecorded(), 
                e.getAmountBudget(), 
                e.getAmountBudgetRemaining(), 
                e.getAmountToUse(), 
                e.getDeltaAmount()));
        }

        listDTO.sort(Comparator.comparing(BgtViewTotalYearCategoryDTO::nature)
            .thenComparing(BgtViewTotalYearCategoryDTO::category));

        return listDTO; 
    }
    
}
