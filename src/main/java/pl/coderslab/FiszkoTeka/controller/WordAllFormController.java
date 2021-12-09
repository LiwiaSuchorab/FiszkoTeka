package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.repository.WordRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/word")
public class WordAllFormController {

    private final WordRepository wordRepository;

    public WordAllFormController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/all")
    public String showAllLogins(Model model) {
        model.addAttribute("word", wordRepository.findAll());
        return "/user/word/wordListing";
    }

    @GetMapping("/category")
    public String findByCatId(@RequestParam long idCategory, Model model) {
        model.addAttribute("word", wordRepository.findAllByCategoriesId(idCategory));
        wordRepository.findAllByCategoriesId(idCategory);
        return "/user/word/categoryDetails";
    }
}