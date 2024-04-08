/* BgtViewTotalYearNatureEntity -> bgt_view_total_year_nature -> totali per anno-natura
 * 		year					int
 * 		nature					string
 * 		amount					bigdecimal
 * */
package com.it.personaldashboard.model.budgeting.view;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "bgt_view_total_year_nature")
@IdClass(BgtViewTotalYearNatureEntityKey.class)
public class BgtViewTotalYearNatureEntity extends ViewModel {
    
    @Id
    @Column(columnDefinition = "year")
    private Integer year;

    @Id
    @Column(columnDefinition = "nature")
    private String nature;

    @Id
    @Column(columnDefinition = "amount")
    private BigDecimal amount;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    

    

}