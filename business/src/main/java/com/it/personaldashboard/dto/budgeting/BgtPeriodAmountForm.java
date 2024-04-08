package com.it.personaldashboard.dto.budgeting;

import java.util.List;

public record BgtPeriodAmountForm(BgtPeriodForm period, List<BgtSubCategoryAmountForm> lstSubCategoryAmount) {}
