package pl.coderslab.FiszkoTeka.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.CustomUserDetails;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.entity.WordUser;
import pl.coderslab.FiszkoTeka.repository.UsersRepository;
import pl.coderslab.FiszkoTeka.repository.WordRepository;
import pl.coderslab.FiszkoTeka.repository.WordUserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/wordUser")
public class WordUsersFormController {

    private final WordUserRepository wordUserRepository;
    private final WordRepository wordRepository;
    private final UsersRepository usersRepository;

    public WordUsersFormController(WordUserRepository wordUserRepository, WordRepository wordRepository, UsersRepository usersRepository) {
        this.wordUserRepository = wordUserRepository;
        this.wordRepository = wordRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/all")
    public String showAllLogins(Authentication authentication, Model model) {
        model.addAttribute("wordUser", wordUserRepository.findAllByUsers_Id(((CustomUserDetails)authentication.getPrincipal()).getId()));
        return "/user/wordUser/wordListing";
    }

    @GetMapping("/add")
    public String prepareAdd(Authentication authentication, Model model) {
        model.addAttribute("wordUser", new WordUser());
        //model.addAttribute("wordUser", usersRepository.getById(((CustomUserDetails)authentication.getPrincipal()).getId()));

        return "/user/wordUser/wordForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("wordUser") @Valid WordUser wordUser, BindingResult result) {
        if(result.hasErrors()){
            return "/user/wordUser/wordForm";
        }
        wordUserRepository.save(wordUser);
        return "redirect:/user/wordUser/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("wordUser", wordUserRepository.getById(idToEdit));
        return "/user/wordUser/wordForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("wordUser") @Valid WordUser wordUser, BindingResult result) {
        if(result.hasErrors()) {
            return "/user/wordUser/wordForm";
        }
        wordUserRepository.save(wordUser);
        return "redirect:/user/wordUser/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("wordUser", wordUserRepository.getById(toRemoveId));
        wordUserRepository.deleteById(toRemoveId);
        return "redirect:/user/wordUser/all";
    }

    @ModelAttribute("users")
    public List<Users> users() {
        return usersRepository.findAll();
    }

}