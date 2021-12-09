package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Word;
import pl.coderslab.FiszkoTeka.entity.WordUser;
import pl.coderslab.FiszkoTeka.repository.WordUserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user/exciseUser")
public class ExciseUserFormController {

    private final WordUserRepository wordUserRepository;

    public ExciseUserFormController(WordUserRepository wordUserRepository) {
        this.wordUserRepository = wordUserRepository;
    }


    @GetMapping("/all")
    public String prepareAdd(Model model) {
        Random random = new Random();
        List<WordUser> wordUsers = wordUserRepository.findAll();
        int randomNumber = random.nextInt(wordUsers.size());
        WordUser randomWord = wordUsers.get(randomNumber);
        model.addAttribute("wordUsers", randomWord);
        model.addAttribute("wordUser", new WordUser());
        return "/user/exciseUser/exciseForm";
    }

    @PostMapping("/all")
    public String save(@RequestParam String firstWord, @ModelAttribute("wordUser") @Valid WordUser wordUser, BindingResult result) {
        if(wordUser.getFirstWord().equals(firstWord)){
            return "/dashboard";
        }
        return "redirect:/user/exciseUser/all";
    }
    @GetMapping("/error")
    public String viewDashboardUserPage() {
        return "/user/exciseUser/error";
    }
}
