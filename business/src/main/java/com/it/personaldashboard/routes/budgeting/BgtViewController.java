package com.it.personaldashboard.routes.budgeting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.it.personaldashboard.dto.budgeting.view.BgtViewTotalYearCategoryDTO;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity.Nature;
import com.it.personaldashboard.services.budgeting.BgtPeriodAmountService;
import com.it.personaldashboard.services.budgeting.BgtViewService;

@Controller
public class BgtViewController {
    
    @Autowired
    private BgtPeriodAmountService bgtPeriodAmountService; 

    @Autowired
    private BgtViewService bgtViewService;

    @GetMapping("/budgeting/home/{year}")
    public String welcomeByYear(Model model, @PathVariable(required = false) Integer year) {

        if(year == null) {
            year = LocalDate.now().getYear();
        }

        model.addAttribute("pageName", "Budgeting - Home");
        model.addAttribute("year", year);
        model.addAttribute("showFragmentList", true);

        model.addAttribute("lst_month_year_nature", bgtViewService.listTotalMonthYearNatureByYear(year));

        model.addAttribute("lst_year_nature", bgtViewService.totalYearNatureByYear(year));
        
        model.addAttribute("lst_op_year_category", bgtViewService.listTotalYearCategoryByNatureAndYear(Nature.COST_OP, year));
        List<BgtViewTotalYearCategoryDTO> lstPlanYearCategory = bgtViewService.listTotalYearCategoryByNatureAndYear(Nature.COST_PLAN, year);
        model.addAttribute("lst_plan_year_category", lstPlanYearCategory);
        model.addAttribute("lst_rev_year_category", bgtViewService.listTotalYearCategoryByNatureAndYear(Nature.REVENUES, year));

        Map<String, BigDecimal> mapPlanAmount = this.calculatePlanAmountFromListByCategory(lstPlanYearCategory);
        model.addAttribute("tot_plan_amount_budget", mapPlanAmount.get("tot_plan_amount_budget"));
        model.addAttribute("tot_plan_amount_to_use", mapPlanAmount.get("tot_plan_amount_to_use"));
        model.addAttribute("tot_plan_amount_delta", mapPlanAmount.get("tot_plan_amount_delta"));

        return "budgeting-home";

    }

    private Map<String, BigDecimal> calculatePlanAmountFromListByCategory(List<BgtViewTotalYearCategoryDTO> lstPlanYearCategory) {

        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal totAmountBudget = BigDecimal.ZERO;
        BigDecimal totAmountToUse = BigDecimal.ZERO;
        BigDecimal totDeltaAmount = BigDecimal.ZERO;
        for(BgtViewTotalYearCategoryDTO bvtyc : lstPlanYearCategory) {
            totAmountBudget = totAmountBudget.add(bvtyc.amountBudget());
            totAmountToUse = totAmountToUse.add(bvtyc.amountToUse());
            totDeltaAmount = totDeltaAmount.add(bvtyc.deltaAmount());
        }
        map.put("tot_plan_amount_budget", totAmountBudget);
        map.put("tot_plan_amount_to_use", totAmountToUse);
        map.put("tot_plan_amount_delta", totDeltaAmount);
        return map;

    }



    @GetMapping("/budgeting/home")
    public String welcome(Model model) {
        Integer year = LocalDate.now().getYear();
        return this.welcomeByYear(model, year);
    }

    @GetMapping("/budgeting/form")
    public String form(Model model) {
        model.addAttribute("pageName", "Budgeting - Form");
        model.addAttribute("showFragmentList", false);
        model.addAttribute("natureTreeView", bgtPeriodAmountService.prepareNatureTreeView());
        return "budgeting-home";
    }

}
