package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.repository.WordRepository;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user/excise")
public class ExciseFormController {

    private final WordRepository wordRepository;

    public ExciseFormController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/all")
    public String prepareAdd(Model model) {
        Random random = new Random();
        List<Word> words = wordRepository.findAll();
        int randomNumber = random.nextInt(words.size());
        Word randomWord = words.get(randomNumber);
        model.addAttribute("words", randomWord);
        model.addAttribute("word", new Word());
        return "/user/excise/exciseForm";
    }

    @PostMapping("/all")
    public String save(@RequestParam String firstWord, @ModelAttribute("word") @Valid Word word, BindingResult result) {
        if(word.getFirstWord().equals(firstWord)){
            return "/user/excise/exciseForm";
        }
        return "redirect:/user/excise/error";
    }
    @GetMapping("/error")
    public String viewDashboardUserPage() {
        return "/user/excise/error";
    }
}
