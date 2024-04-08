package com.it.personaldashboard.model.budgeting;

import com.it.personaldashboard.model.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "bgt_period_amount")
public class BgtPeriodAmountEntity extends Model {

    @ManyToOne
    @JoinColumn(name="fk_period")
    private BgtPeriodEntity period;

    @ManyToOne
    @JoinColumn(name="fk_subcategory")
    private BgtSubCategoryEntity subCategory;

    private BigDecimal amount;

    public BgtPeriodEntity getPeriod() {
        return period;
    }

    public void setPeriod(BgtPeriodEntity period) {
        this.period = period;
    }

    public BgtSubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(BgtSubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    

}