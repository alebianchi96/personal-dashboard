package com.it.personaldashboard.jpa.budgeting.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearNatureEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalYearNatureEntityKey;

public interface BgtViewTotalYearNatureDao 
    extends JpaRepository<BgtViewTotalYearNatureEntity, BgtViewTotalYearNatureEntityKey>{

    List<BgtViewTotalYearNatureEntity> findAllTotalYearNatureByYear(Integer year);
    
}
