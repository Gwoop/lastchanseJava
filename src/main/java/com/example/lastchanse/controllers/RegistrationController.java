package com.example.lastchanse.controllers;

import com.example.lastchanse.models.Person;
import com.example.lastchanse.models.Role;
import com.example.lastchanse.models.User;
import com.example.lastchanse.pacege.PersonRepository;
import com.example.lastchanse.pacege.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String reg_view(Model model)
    {

        model.addAttribute("reg",new User());
        model.addAttribute("per", new Person());
        return "registration";
    }

    @PostMapping("/registration")
    public String reg_action(@ModelAttribute("reg") @Valid User user, BindingResult bindingResultreg,
                             @ModelAttribute("per") @Valid Person person, BindingResult bindingResultper,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("first_name") String first_name,
                             @RequestParam("middle_name") String middle_name,
                             Model model)
    {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null)
        {
            model.addAttribute(
                    "error",
                    "Такой пользователь уже существует");
            return "registration";
        }

        if (user.getPassword() == null){
            model.addAttribute("paswwordval", "Поле не может быть пустым");
            return "registration";
        }
        if(bindingResultreg.hasErrors()) return "registration";
        if(bindingResultper.hasErrors()) return "registration";
        //password = passwordEncoder.encode(password);
        user.setUsername(username);
        // user.setPassword(passwordEncoder.encode(password));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        person.setName(name);
        person.setFirst_name(first_name);
        person.setMiddle_name(middle_name);
        person.setUser(user);
        personRepository.save(person);


        return "redirect:/login";
    }


}
