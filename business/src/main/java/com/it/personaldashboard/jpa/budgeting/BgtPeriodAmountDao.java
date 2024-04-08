package com.it.personaldashboard.jpa.budgeting;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.BgtPeriodAmountEntity;


public interface BgtPeriodAmountDao extends JpaRepository<BgtPeriodAmountEntity, UUID> {
    
}
