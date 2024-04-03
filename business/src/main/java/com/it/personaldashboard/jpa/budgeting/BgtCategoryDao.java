package com.it.personaldashboard.jpa.budgeting;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.personaldashboard.model.budgeting.BgtCategoryEntity;

public interface BgtCategoryDao extends JpaRepository<BgtCategoryEntity, UUID> {
    
}
