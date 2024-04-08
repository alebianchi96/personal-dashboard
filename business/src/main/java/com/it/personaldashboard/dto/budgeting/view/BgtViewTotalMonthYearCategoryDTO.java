package com.it.personaldashboard.dto.budgeting.view;

import java.math.BigDecimal;

public record BgtViewTotalMonthYearCategoryDTO(
    Integer monthIndex,
    String month,
    Integer year,
    String category,
    String nature,
    BigDecimal amount
) {
    
}
