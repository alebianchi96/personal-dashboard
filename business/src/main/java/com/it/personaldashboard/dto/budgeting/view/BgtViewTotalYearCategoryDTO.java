package com.it.personaldashboard.dto.budgeting.view;

import java.math.BigDecimal;

public record BgtViewTotalYearCategoryDTO(
    Integer year,
    String nature,
    String category,
    BigDecimal amountRecorded,
    BigDecimal amountBudget,
    BigDecimal amountBudgetRemaining,
    BigDecimal amountToUse,
    BigDecimal deltaAmount
) {
    
}
