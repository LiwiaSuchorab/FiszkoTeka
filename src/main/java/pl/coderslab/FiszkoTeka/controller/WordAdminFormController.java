package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Category;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.repository.CategoryRepository;
import pl.coderslab.FiszkoTeka.repository.WordRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/word")
public class WordAdminFormController {

    private final WordRepository wordRepository;
    private final CategoryRepository categoryRepository;

    public WordAdminFormController(WordRepository wordRepository, CategoryRepository categoryRepository) {
        this.wordRepository = wordRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/add")
    public String prepareAdd(Model model) {
        model.addAttribute("word", new Word());
        return "/admin/word/wordForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("word") @Valid Word word, BindingResult result) {
        if(result.hasErrors()){
            return "/admin/word/wordForm";
        }
        wordRepository.save(word);
        return "redirect:/user/word/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("word", wordRepository.getById(idToEdit));
        return "/admin/word/wordForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("word") @Valid Word word, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/word/wordForm";
        }
        wordRepository.save(word);
        return "redirect:/user/word/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("word", wordRepository.getById(toRemoveId));
        wordRepository.deleteById(toRemoveId);
        return "redirect:/admin/word/all";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

}