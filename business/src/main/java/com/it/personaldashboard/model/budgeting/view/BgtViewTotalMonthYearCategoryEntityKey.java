/* BgtViewTotalMonthYearCategoryEntity -> bgt_view_total_month_year_category -> totali per mese-anno-categoria
 * 		month					string
 * 		year					int
 * 		category				string
 * 		nature					string
 * 		amount					bigdecimal
 * */
package com.it.personaldashboard.model.budgeting.view;

import java.io.Serializable;
import java.math.BigDecimal;


public class BgtViewTotalMonthYearCategoryEntityKey implements Serializable {

    private String month;

    private Integer year;

    private String category;

    private String nature;

    private BigDecimal amount;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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