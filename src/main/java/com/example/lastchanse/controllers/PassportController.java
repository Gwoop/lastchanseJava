package com.example.lastchanse.controllers;


import com.example.lastchanse.models.Passport;
import com.example.lastchanse.models.Person;
import com.example.lastchanse.pacege.PassportPepository;
import com.example.lastchanse.pacege.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private PassportPepository passportPepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Passport> tasks = passportPepository.findAll();
        model.addAttribute("courses",tasks);
        return "passport/index";
    }
    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("courses",new Passport());
        return "passport/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("course") @Valid Passport course, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "passport/index";
        passportPepository.save(course);
        return "redirect:/passport/add";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        Optional<Passport> news = passportPepository.findById(id);
        ArrayList<Passport> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("courses",newsArrayList);
        return "passport/task";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Passport course = passportPepository.findById(id).orElseThrow();
        passportPepository.delete(course);
        //newsRepository.deleteById(id);
        return "redirect:/passport/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!passportPepository.existsById(id)){
            return "redirect:/passport/{id}";
        }
        Optional<Passport> course = passportPepository.findById(id);
        ArrayList<Passport> taskArrayList = new ArrayList<>();
        course.ifPresent(taskArrayList::add);
        model.addAttribute("courses",taskArrayList.get(0));
        return "passport/edit";
    }

    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id, @ModelAttribute("courses")
    @Valid Passport course, BindingResult bindingResult,
                           Model model)
    {
        if (!passportPepository.existsById(id)){return "task:/passport/";}
        if (bindingResult.hasErrors()){return "passport/edit";}
        passportPepository.save(course);
        return "redirect:/passport/{id}";
    }

}
