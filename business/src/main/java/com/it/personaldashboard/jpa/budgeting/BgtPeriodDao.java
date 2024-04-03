package com.it.personaldashboard.jpa.budgeting;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.BgtPeriodEntity;

public interface BgtPeriodDao extends JpaRepository<BgtPeriodEntity, UUID> {
    
}
