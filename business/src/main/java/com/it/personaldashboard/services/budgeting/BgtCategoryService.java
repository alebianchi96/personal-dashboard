package com.it.personaldashboard.services.budgeting;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.it.personaldashboard.configuration.InitDatabaseValues;
import com.it.personaldashboard.jpa.budgeting.BgtCategoryDao;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity;
import com.it.personaldashboard.services.IService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BgtCategoryService implements IService {

    @Autowired
    private BgtCategoryDao bgtCategoryDao;

    @Override
    public void executeInit() {
        
        log.info("    executeInit > START > {}", this.getClass().getSimpleName());

        int inserted = 0;
        for(BgtCategoryEntity bgtCategory : InitDatabaseValues.listInitBgtCategoryEntity()) {
            if(bgtCategory == null || bgtCategoryDao.exists(Example.of(bgtCategory))) { continue; }
            bgtCategory.setId(UUID.randomUUID());
            bgtCategoryDao.save(bgtCategory);
            inserted++;
        }

        log.info("    executeInit > END > {} > inserted: {}", this.getClass().getSimpleName(), inserted);
        
    }
    
}
