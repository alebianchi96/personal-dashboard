package com.it.personaldashboard.jpa.budgeting.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearCategoryEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearCategoryEntityKey;

public interface BgtViewTotalYearCategoryDao 
    extends JpaRepository<BgtViewTotalYearCategoryEntity, BgtViewTotalYearCategoryEntityKey>{

    List<BgtViewTotalYearCategoryEntity> findAllTotalYearCategoryByNatureAndYear(String nature, Integer year);
    
}
