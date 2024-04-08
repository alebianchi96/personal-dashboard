/* BgtViewNumberPeriodsYearEntity -> bgt_view_number_periods_year
 * 		year					int
 * 		periods_recorded		int
 * */
package com.it.personaldashboard.model.budgeting.view;

import java.io.Serializable;

public class BgtViewNumberPeriodsYearEntityKey implements Serializable {

    private Integer year;

    private Integer periodsRecorded;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPeriodsRecorded() {
        return periodsRecorded;
    }

    public void setPeriodsRecorded(Integer periodsRecorded) {
        this.periodsRecorded = periodsRecorded;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}