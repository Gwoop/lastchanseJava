package com.example.lastchanse.controllers;


import com.example.lastchanse.models.Ochenka;
import com.example.lastchanse.models.Person;
import com.example.lastchanse.pacege.Ochenkarepository;
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
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Person> tasks = personRepository.findAll();
        model.addAttribute("courses",tasks);
        return "person/index";
    }
    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("courses",new Person());
        return "person/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("course") @Valid Person course, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "task/index";
        personRepository.save(course);
        return "redirect:/person/add";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        Optional<Person> news = personRepository.findById(id);
        ArrayList<Person> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("courses",newsArrayList);
        return "person/task";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Person course = personRepository.findById(id).orElseThrow();
        personRepository.delete(course);
        //newsRepository.deleteById(id);
        return "redirect:/person/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!personRepository.existsById(id)){
            return "redirect:/person/{id}";
        }
        Optional<Person> course = personRepository.findById(id);
        ArrayList<Person> taskArrayList = new ArrayList<>();
        course.ifPresent(taskArrayList::add);
        model.addAttribute("courses",taskArrayList.get(0));
        return "person/edit";
    }

    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id, @ModelAttribute("courses")
    @Valid Person course, BindingResult bindingResult,
                           Model model)
    {
        if (!personRepository.existsById(id)){return "task:/person/";}
        if (bindingResult.hasErrors()){return "person/edit";}

        personRepository.save(course);
        return "redirect:/person/{id}";
    }


}
