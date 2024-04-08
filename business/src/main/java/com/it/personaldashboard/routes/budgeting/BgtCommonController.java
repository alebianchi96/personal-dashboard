package com.it.personaldashboard.routes.budgeting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.personaldashboard.dto.budgeting.BgtPeriodAmountForm;
import com.it.personaldashboard.dto.budgeting.view.BgtNatureTree;
import com.it.personaldashboard.services.budgeting.BgtPeriodAmountService;
import com.it.personaldashboard.services.budgeting.BgtViewService;

@RestController
@RequestMapping("/api/budgeting")
public class BgtCommonController {


    @Autowired
    private BgtPeriodAmountService bgtPeriodAmountService;

    @Autowired
    private BgtViewService bgtViewService;

    
    @PostMapping("/")
    public BgtPeriodAmountForm receiveBgtPeriodAmount(@RequestBody BgtPeriodAmountForm form) {
        return bgtPeriodAmountService.save(form);
    }


    @GetMapping("/")
    public List<BgtNatureTree> prepNatureTree() {
        return bgtPeriodAmountService.prepareNatureTreeView();
    }



    @GetMapping("/test")
    public void test() {
        bgtViewService.test();
    }


}
