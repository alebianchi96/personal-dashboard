package com.it.personaldashboard.model.budgeting.view;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class ViewModel {
    
    @Override
    public String toString() {
        try {
            return new JsonMapper().writeValueAsString(this);    
        } catch (Exception e) {
            // handle exception
        }
        return "";
    }

}
