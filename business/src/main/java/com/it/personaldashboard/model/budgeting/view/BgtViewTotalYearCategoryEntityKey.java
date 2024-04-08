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

import java.io.Serializable;
import java.math.BigDecimal;

public class BgtViewTotalYearCategoryEntityKey implements Serializable {

    private Integer year;

    private String nature;

    private String category;

    private BigDecimal amountRecorded;

    private BigDecimal amountBudget;

    private BigDecimal amountBudgetRemaining;

    private BigDecimal amountToUse;

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}