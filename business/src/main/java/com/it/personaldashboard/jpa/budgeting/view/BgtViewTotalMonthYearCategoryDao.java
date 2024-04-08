package com.it.personaldashboard.jpa.budgeting.view;


import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewTotalMonthYearCategoryEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalMonthYearCategoryEntityKey;

public interface BgtViewTotalMonthYearCategoryDao 
    extends JpaRepository<BgtViewTotalMonthYearCategoryEntity, BgtViewTotalMonthYearCategoryEntityKey>{

    
}
