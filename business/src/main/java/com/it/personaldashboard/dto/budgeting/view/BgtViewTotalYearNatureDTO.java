package com.it.personaldashboard.dto.budgeting.view;

import java.math.BigDecimal;

public record BgtViewTotalYearNatureDTO(
    Integer year,
    String nature,
    BigDecimal amount
) {
    
}
