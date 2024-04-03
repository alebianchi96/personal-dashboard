package com.it.personaldashboard.model.budgeting;

import com.it.personaldashboard.model.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "bgt_period")
public class BgtPeriodEntity extends Model {

    public BgtPeriodEntity(){}

    public BgtPeriodEntity(String month, Integer year){
        this.month = month;
        this.year = year;
    }

    public BgtPeriodEntity(UUID id, String month, Integer year){
        this(month, year);
        super.setId(id);
    }

    private String month;

    private Integer year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}