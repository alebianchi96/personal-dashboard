package com.it.personaldashboard.jpa.budgeting.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.view.BgtViewTotalMonthYearNatureEntity;
import com.it.personaldashboard.model.budgeting.view.BgtViewTotalMonthYearNatureEntityKey;

public interface BgtViewTotalMonthYearNatureDao 
    extends JpaRepository<BgtViewTotalMonthYearNatureEntity, BgtViewTotalMonthYearNatureEntityKey>{

    List<BgtViewTotalMonthYearNatureEntity> findAllTotalMonthYearNatureByYear(Integer year);

}
