package com.it.personaldashboard.model.budgeting;

import com.it.personaldashboard.model.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "bgt_subcategories")
public class BgtSubCategoryEntity extends Model {

    public BgtSubCategoryEntity(){}

    public BgtSubCategoryEntity(String name, BigDecimal annualAmount, BgtCategoryEntity category){
        this.name = name;
        this.annualAmount = annualAmount;
        this.category = category;
    }

    private String name;

    @ManyToOne
    @JoinColumn(name="fk_category")
    private BgtCategoryEntity category;

    private BigDecimal annualAmount;

    public BgtCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(BgtCategoryEntity category) {
        this.category = category;
    }

    public BigDecimal getAnnualAmount() {
        return annualAmount;
    }

    public void setAnnualAmount(BigDecimal annualAmount) {
        this.annualAmount = annualAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
