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
@RequestMapping("/admin/category")
public class CategoryAdminFormController {

    private final CategoryRepository categoryRepository;
    private final WordAdminFormController wordAdminFormController;

    public CategoryAdminFormController(CategoryRepository categoryRepository, WordAdminFormController wordAdminFormController) {
        this.categoryRepository = categoryRepository;
        this.wordAdminFormController = wordAdminFormController;
    }

    @GetMapping("/add")
    public String prepareAdd(Model model) {
        model.addAttribute("category", new Category());
        return "/admin/category/categoryForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/category/categoryForm";
        }
        categoryRepository.save(category);
        return "redirect:/user/category/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("category", categoryRepository.getById(idToEdit));
        return "/admin/category/categoryForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/category/categoryForm";
        }
        categoryRepository.save(category);
        return "redirect:/user/category/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("category", categoryRepository.getById(toRemoveId));
        categoryRepository.deleteById(toRemoveId);
        return "redirect:/user/category/all";
    }

}
