/* BgtViewTotalYearNatureEntity -> bgt_view_total_year_nature -> totali per anno-natura
 * 		year					int
 * 		nature					string
 * 		amount					bigdecimal
 * */
package com.it.personaldashboard.model.budgeting.view;

import java.io.Serializable;
import java.math.BigDecimal;

public class BgtViewTotalYearNatureEntityKey implements Serializable {

    private Integer year;

    private String nature;

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}