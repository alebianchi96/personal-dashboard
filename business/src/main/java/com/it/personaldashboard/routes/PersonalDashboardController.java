package com.it.personaldashboard.routes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalDashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("pageName", "Dashboard");

        return "dashboard";

    }

}
