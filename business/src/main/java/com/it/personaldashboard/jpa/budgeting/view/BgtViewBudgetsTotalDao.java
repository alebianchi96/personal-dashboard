package com.it.personaldashboard.jpa.budgeting.view;


import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewBudgetsTotalEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewBudgetsTotalEntityKey;

public interface BgtViewBudgetsTotalDao 
    extends JpaRepository<BgtViewBudgetsTotalEntity, BgtViewBudgetsTotalEntityKey> {
    
}
