package com.it.personaldashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.it.personaldashboard.services.budgeting.BgtCategoryService;
import com.it.personaldashboard.services.budgeting.BgtPeriodService;
import com.it.personaldashboard.services.budgeting.BgtSubCategoryService;

@Component
public class InitDatabaseService {

    @Autowired
    private BgtCategoryService bgtCategoryService;

    @Autowired
    private BgtSubCategoryService bgtSubCategoryService;

    @Autowired
    private BgtPeriodService bgtPeriodService;

    public void executeInit() {

        // 1. Inizializzare la tabella BgtCategory("bgt_categories") se non gia' inizializzata
        bgtCategoryService.executeInit();
        // 2. Inizializzare la tabella BgtSubCategory("bgt_subcategories") se non gia' inizializzata
        bgtSubCategoryService.executeInit();
        // 3. Inizializzare la tabella BgtPeriod("bgt_period") se non gia' inizializzata
        bgtPeriodService.executeInit();

    }
    
}
