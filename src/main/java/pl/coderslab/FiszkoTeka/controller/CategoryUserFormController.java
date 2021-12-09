package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Category;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.repository.CategoryRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/category")
public class CategoryUserFormController {

    private final CategoryRepository categoryRepository;
    private final WordAdminFormController wordAdminFormController;

    public CategoryUserFormController(CategoryRepository categoryRepository, WordAdminFormController wordAdminFormController) {
        this.categoryRepository = categoryRepository;
        this.wordAdminFormController = wordAdminFormController;
    }


    @GetMapping("/all")
    public String showAllLogins(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "/user/category/categoryListing";
    }
}
