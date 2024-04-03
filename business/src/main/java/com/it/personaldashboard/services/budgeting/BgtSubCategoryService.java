package com.it.personaldashboard.services.budgeting;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.it.personaldashboard.configuration.InitDatabaseValues;
import com.it.personaldashboard.jpa.budgeting.BgtCategoryDao;
import com.it.personaldashboard.jpa.budgeting.BgtSubCategoryDao;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity;
import com.it.personaldashboard.model.budgeting.BgtSubCategoryEntity;
import com.it.personaldashboard.services.IService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BgtSubCategoryService implements IService {

    @Autowired
    private BgtCategoryDao bgtCategoryDao;

    @Autowired
    private BgtSubCategoryDao bgtSubCategoryDao;

    @Override
    public void executeInit() {
        
        log.info("    executeInit > START > {}", this.getClass().getSimpleName());
        
        int inserted = 0;
        if(bgtSubCategoryDao.findAll().isEmpty()) {
            for(BgtSubCategoryEntity subbgtCategory : InitDatabaseValues.listInitBgtSubCategoryEntity()) {
                subbgtCategory.setId(UUID.randomUUID());
                BgtCategoryEntity exampleCategory = subbgtCategory.getCategory();
                exampleCategory.setId(null);
                subbgtCategory.setCategory(bgtCategoryDao.findOne(Example.of(exampleCategory)).get());
                bgtSubCategoryDao.save(subbgtCategory);
                inserted++;
            }
        }

        log.info("    executeInit > END > {} > inserted: {}", this.getClass().getSimpleName(), inserted);
        
    }
    
}
