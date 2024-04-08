package com.it.personaldashboard.dto.budgeting.view;

import java.math.BigDecimal;

public record BgtViewTotalMonthYearNatureDTO(
    Integer indexMonth,
    String month,
    Integer year,
    String nature,
    BigDecimal amount
) {
    
}
