package com.it.personaldashboard.dto.budgeting.view;

import java.util.List;

import com.it.personaldashboard.dto.budgeting.BgtCategoryDTO;

public record BgtNatureTree(String nature, String natureLabel, List<BgtCategoryDTO> categories) {}
