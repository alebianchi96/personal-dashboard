/* BgtViewTotalMonthYearCategoryEntity -> bgt_view_total_month_year_category -> totali per mese-anno-categoria
 * 		month					string
 * 		year					int
 * 		category				string
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
@Table(name = "bgt_view_total_month_year_category")
@IdClass(BgtViewTotalMonthYearCategoryEntityKey.class)
public class BgtViewTotalMonthYearCategoryEntity extends ViewModel {
    
    @Id
    @Column(columnDefinition = "month")
    private String month;

    @Id
    @Column(columnDefinition = "year")
    private Integer year;

    @Id
    @Column(columnDefinition = "category")
    private String category;

    @Id
    @Column(columnDefinition = "nature")
    private String nature;

    @Id
    @Column(columnDefinition = "amount")
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
    
    

}