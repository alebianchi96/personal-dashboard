package com.it.personaldashboard.services.budgeting;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.it.personaldashboard.configuration.InitDatabaseValues;
import com.it.personaldashboard.jpa.budgeting.BgtPeriodDao;
import com.it.personaldashboard.model.budgeting.BgtPeriodEntity;
import com.it.personaldashboard.services.IService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BgtPeriodService implements IService {

    @Autowired
    private BgtPeriodDao bgtPeriodDao;

    @Override
    public void executeInit() {
        
        log.info("    executeInit > START > {}", this.getClass().getSimpleName());

        int inserted = 0;
        for(BgtPeriodEntity bgtPeriod : InitDatabaseValues.listInitBgtPeriodEntity()) {
            if(bgtPeriod == null || bgtPeriodDao.exists(Example.of(bgtPeriod))) { continue; }
            bgtPeriod.setId(UUID.randomUUID());
            bgtPeriodDao.save(bgtPeriod);
            inserted++;
        }

        log.info("    executeInit > END > {} > inserted: {}", this.getClass().getSimpleName(), inserted);
        
    }
    
}
