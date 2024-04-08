package com.it.personaldashboard.dto.budgeting;

import java.util.List;

public record BgtCategoryDTO(String id, String name, String nature, List<BgtSubCategoryDTO> listSubCategories) { }
