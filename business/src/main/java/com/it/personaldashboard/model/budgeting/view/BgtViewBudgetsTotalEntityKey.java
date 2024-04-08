package com.it.personaldashboard.model.budgeting.view;

import java.io.Serializable;
import java.math.BigDecimal;


public class BgtViewBudgetsTotalEntityKey implements Serializable {
    
    private BigDecimal amountBudgetYear;
    
    private Integer amountBudgetMonth;
    
    public BigDecimal getAmountBudgetYear() {
        return amountBudgetYear;
    }
    public void setAmountBudgetYear(BigDecimal amountBudgetYear) {
        this.amountBudgetYear = amountBudgetYear;
    }
    public Integer getAmountBudgetMonth() {
        return amountBudgetMonth;
    }
    public void setAmountBudgetMonth(Integer amountBudgetMonth) {
        this.amountBudgetMonth = amountBudgetMonth;
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