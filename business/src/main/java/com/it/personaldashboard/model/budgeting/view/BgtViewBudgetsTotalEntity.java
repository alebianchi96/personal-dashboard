package com.it.personaldashboard.model.budgeting.view;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "bgt_view_budgets_total")
@IdClass(BgtViewBudgetsTotalEntityKey.class)
public class BgtViewBudgetsTotalEntity extends ViewModel {
    
    @Id
    @Column(columnDefinition = "amount_budget_year")
    private BigDecimal amountBudgetYear;

    @Column(columnDefinition = "amount_budget_month")
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

}
