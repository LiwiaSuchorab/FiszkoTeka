package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.FiszkoTeka.entity.Role;

import javax.validation.Valid;


@Controller
public class HomeFormController {

    @GetMapping("/")
    public String viewHomePage() {
        return "/index";
    }

    @GetMapping("/dashboard")
    public String viewDashboardUserPage() {
        return "/dashboard";
    }

}