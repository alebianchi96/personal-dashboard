package com.it.personaldashboard.jpa.budgeting.view;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewNumberPeriodsYearEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewNumberPeriodsYearEntityKey;

public interface BgtViewNumberPeriodsYearDao 
    extends JpaRepository<BgtViewNumberPeriodsYearEntity, BgtViewNumberPeriodsYearEntityKey>{
    
}
