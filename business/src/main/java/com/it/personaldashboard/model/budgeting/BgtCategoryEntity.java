package com.it.personaldashboard.model.budgeting;

import com.it.personaldashboard.model.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "bgt_categories")
public class BgtCategoryEntity extends Model {

    public BgtCategoryEntity(){}

    public BgtCategoryEntity(String name, Nature nature){
        this.name = name;
        this.nature = nature;
    }

    public BgtCategoryEntity(UUID id, String name, Nature nature){
        super.setId(id);
        this.name = name;
        this.nature = nature;
    }


    private String name;

    @Enumerated(EnumType.STRING)
    private Nature nature;

    public enum Nature {
        COST_OP, COST_PLAN, REVENUES;

        public static String getLabel(String name) {
            if(COST_OP.name().equalsIgnoreCase(name)) { return "Costi operativi"; }
            else if(COST_PLAN.name().equalsIgnoreCase(name)) { return "Costi pianificati"; }
            else if(REVENUES.name().equalsIgnoreCase(name)) { return "Ricavi"; }
            return "";
        }
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

}
