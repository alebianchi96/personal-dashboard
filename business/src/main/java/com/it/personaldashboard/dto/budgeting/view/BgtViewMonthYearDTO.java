package com.it.personaldashboard.dto.budgeting.view;

import java.util.List;

public record BgtViewMonthYearDTO(
    Integer indexMonth, 
    String month,
    Integer year,
    List<BgtViewTotalMonthYearNatureDTO> listNatureAmount
) {
    
}
