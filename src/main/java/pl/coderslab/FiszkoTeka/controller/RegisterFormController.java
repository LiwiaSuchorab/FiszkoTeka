package pl.coderslab.FiszkoTeka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.FiszkoTeka.entity.Users;
import pl.coderslab.FiszkoTeka.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterFormController {

    private final UsersRepository usersRepository;

    public RegisterFormController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/all")
    public String showAllLogins(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "/register/registerListing";
    }

    @GetMapping("/add")
    public String prepareAdd(Model model) {
        model.addAttribute("users", new Users());
        return "/register/registerForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("users") @Valid Users users, BindingResult result) {
        if(result.hasErrors()){
            return "/register/registerForm";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        usersRepository.save(users);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("users", usersRepository.getById(idToEdit));
        return "/register/registerForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("users") @Valid Users users, BindingResult result) {
        if(result.hasErrors()) {
            return "/register/registerForm";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        usersRepository.save(users);
        return "redirect:/register/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("users", usersRepository.getById(toRemoveId));
        usersRepository.deleteById(toRemoveId);
        return "redirect:/register/all";
    }

}
