/* BgtViewNumberPeriodsYearEntity -> bgt_view_number_periods_year
 * 		year					int
 * 		periods_recorded		int
 * */
package com.it.personaldashboard.model.budgeting.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "bgt_view_number_periods_year")
@IdClass(BgtViewNumberPeriodsYearEntityKey.class)
public class BgtViewNumberPeriodsYearEntity extends ViewModel {
    
    @Id
    @Column(columnDefinition = "year")
    private Integer year;

    @Column(columnDefinition = "periods_recorded")
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

    

}