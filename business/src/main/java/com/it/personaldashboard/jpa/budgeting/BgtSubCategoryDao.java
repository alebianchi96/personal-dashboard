package com.it.personaldashboard.jpa.budgeting;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.BgtSubCategoryEntity;

public interface BgtSubCategoryDao extends JpaRepository<BgtSubCategoryEntity, UUID> {
    
}
