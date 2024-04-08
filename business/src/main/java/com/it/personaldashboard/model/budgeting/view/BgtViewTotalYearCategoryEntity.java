/*	BgtViewTotalYearCategoryEntity -> bgt_view_total_year_category -> totali per anno-categoria
 * 		year					int
 *		nature					string
 *		category				string
 *		amount_recorded			bigdecimal
 *		amount_budget			bigdecimal
 *		amount_budget_remaining	bigdecimal
 *		amount_to_use			bigdecimal
 *		delta_amount			bigdecimal
 * */
package com.it.personaldashboard.model.budgeting.view;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "bgt_view_total_year_category")
@IdClass(BgtViewTotalYearCategoryEntityKey.class)
public class BgtViewTotalYearCategoryEntity extends ViewModel {
    
    @Id
    @Column(columnDefinition = "year")
    private Integer year;

    @Id
    @Column(columnDefinition = "nature")
    private String nature;

    @Id
    @Column(columnDefinition = "category")
    private String category;

    @Id
    @Column(columnDefinition = "amount_recorded")
    private BigDecimal amountRecorded;

    @Id
    @Column(columnDefinition = "amount_budget")
    private BigDecimal amountBudget;

    @Id
    @Column(columnDefinition = "amount_budget_remaining")
    private BigDecimal amountBudgetRemaining;

    @Id
    @Column(columnDefinition = "amount_to_use")
    private BigDecimal amountToUse;

    @Id
    @Column(columnDefinition = "delta_amount")
    private BigDecimal deltaAmount;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmountRecorded() {
        return amountRecorded;
    }

    public void setAmountRecorded(BigDecimal amountRecorded) {
        this.amountRecorded = amountRecorded;
    }

    public BigDecimal getAmountBudget() {
        return amountBudget;
    }

    public void setAmountBudget(BigDecimal amountBudget) {
        this.amountBudget = amountBudget;
    }

    public BigDecimal getAmountBudgetRemaining() {
        return amountBudgetRemaining;
    }

    public void setAmountBudgetRemaining(BigDecimal amountBudgetRemaining) {
        this.amountBudgetRemaining = amountBudgetRemaining;
    }

    public BigDecimal getAmountToUse() {
        return amountToUse;
    }

    public void setAmountToUse(BigDecimal amountToUse) {
        this.amountToUse = amountToUse;
    }

    public BigDecimal getDeltaAmount() {
        return deltaAmount;
    }

    public void setDeltaAmount(BigDecimal deltaAmount) {
        this.deltaAmount = deltaAmount;
    }

    
    

}