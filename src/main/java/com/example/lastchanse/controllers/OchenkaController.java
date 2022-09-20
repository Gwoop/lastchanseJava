package com.example.lastchanse.controllers;


import com.example.lastchanse.models.Course;
import com.example.lastchanse.models.Ochenka;
import com.example.lastchanse.pacege.CourseReposito;
import com.example.lastchanse.pacege.Ochenkarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/ochenka")
public class OchenkaController {


    @Autowired
    private Ochenkarepository ochenkarepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Ochenka> tasks = ochenkarepository.findAll();
        model.addAttribute("courses",tasks);
        return "ochenka/index";
    }
    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("courses",new Ochenka());
        return "ochenka/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("course") @Valid Ochenka course, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "task/index";
        ochenkarepository.save(course);
        return "redirect:/ochenka/add";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        Optional<Ochenka> news = ochenkarepository.findById(id);
        ArrayList<Ochenka> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("courses",newsArrayList);
        return "ochenka/task";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Ochenka course = ochenkarepository.findById(id).orElseThrow();
        ochenkarepository.delete(course);
        //newsRepository.deleteById(id);
        return "redirect:/courses/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!ochenkarepository.existsById(id)){
            return "redirect:/ochenka/{id}";
        }
        Optional<Ochenka> course = ochenkarepository.findById(id);
        ArrayList<Ochenka> taskArrayList = new ArrayList<>();
        course.ifPresent(taskArrayList::add);
        model.addAttribute("courses",taskArrayList.get(0));
        return "ochenka/edit";
    }

    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id, @ModelAttribute("courses")
    @Valid Ochenka course, BindingResult bindingResult,
                           Model model)
    {
        if (!ochenkarepository.existsById(id)){return "task:/task/";}
        if (bindingResult.hasErrors()){return "task/edit-task";}

        ochenkarepository.save(course);
        return "redirect:/ochenka/{id}";
    }
}
