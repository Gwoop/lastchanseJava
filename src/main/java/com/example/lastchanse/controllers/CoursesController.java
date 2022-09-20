package com.example.lastchanse.controllers;


import com.example.lastchanse.models.*;
import com.example.lastchanse.pacege.CourseReposito;
import com.example.lastchanse.pacege.Taskrepository;
import com.example.lastchanse.pacege.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CoursesController {


    @Autowired
    private CourseReposito courseReposito;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Taskrepository taskrepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Course> tasks = courseReposito.findAll();
        model.addAttribute("courses",tasks);
        return "courses/index";
    }
    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("courses",new Course());
        return "courses/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "task/index";
        courseReposito.save(course);
        return "redirect:/courses/add";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        Optional<Course> news = courseReposito.findById(id);
        ArrayList<Course> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("courses",newsArrayList);
        return "courses/task";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {
        Course course = courseReposito.findById(id).orElseThrow();
        courseReposito.delete(course);
        //newsRepository.deleteById(id);
        return "redirect:/courses/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!courseReposito.existsById(id)){
            return "redirect:/courses/{id}";
        }
        Optional<Course> course = courseReposito.findById(id);
        ArrayList<Course> taskArrayList = new ArrayList<>();
        course.ifPresent(taskArrayList::add);
        model.addAttribute("courses",taskArrayList.get(0));
        return "courses/edit";
    }

    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id, @ModelAttribute("courses")
    @Valid Course course, BindingResult bindingResult,
                           Model model)
    {
        if (!courseReposito.existsById(id)){return "task:/task/";}
        if (bindingResult.hasErrors()){return "task/edit-task";}

        courseReposito.save(course);
        return "redirect:/courses/{id}";
    }

}
