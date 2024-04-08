package com.it.personaldashboard.dto.budgeting;

import java.math.BigDecimal;

public record BgtSubCategoryAmountForm(BgtSubCategoryForm subcategory, BigDecimal amount) {}
