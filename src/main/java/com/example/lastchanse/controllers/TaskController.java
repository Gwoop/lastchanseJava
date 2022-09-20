package com.example.lastchanse.controllers;


import com.example.lastchanse.models.Course;
import com.example.lastchanse.models.Setting_Task;
import com.example.lastchanse.models.Task;
import com.example.lastchanse.models.Type_Task;
import com.example.lastchanse.pacege.Ochenkarepository;
import com.example.lastchanse.pacege.Setting_taskrepository;
import com.example.lastchanse.pacege.Taskrepository;
import com.example.lastchanse.pacege.Type_taskrepositpry;
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
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private Taskrepository taskrepository;
    @Autowired
    private Type_taskrepositpry type_taskrepositpry;
    @Autowired
    private Setting_taskrepository setting_taskrepository;
    @Autowired
    private Ochenkarepository ochenkarepository;


    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Task> tasks = taskrepository.findAll();
        model.addAttribute("task",tasks);
        return "task/index";
    }
    @GetMapping("/add")
    public String addView(Model model)
    {
        model.addAttribute("task",new Task());
        Iterable<Type_Task> type_tasks = type_taskrepositpry.findAll();
        model.addAttribute("type_tasks",type_tasks);
        Iterable<Setting_Task> setting_tasks = setting_taskrepository.findAll();
        model.addAttribute("setting_tasks",setting_tasks);
        return "task/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("task") @Valid Task task, Course course, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) return "task/index";
        //task.setCourses1(course);
       /* task.getCourses1(1);
        task.setType_task(1);
        task.setSetting_task(1);
        taskrepository.save(task);*/
        return "redirect:/task/add";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") Long id, Model model)
    {
        List<Task> tasks = taskrepository.findByCourses1_id(id);
        model.addAttribute("task",tasks);
        return "task/task";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Long id)
    {


        Task task = taskrepository.findById(id).orElseThrow();
        taskrepository.delete(task);

        //newsRepository.deleteById(id);

        return "redirect:/task/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        if (!taskrepository.existsById(id)){
            return "redirect:/task/{id}";
        }
        Optional<Task> task = taskrepository.findById(id);
        ArrayList<Task> taskArrayList = new ArrayList<>();
        task.ifPresent(taskArrayList::add);
        model.addAttribute("task",taskArrayList.get(0));

        Iterable<Type_Task> type_tasks = type_taskrepositpry.findAll();
        model.addAttribute("type_tasks",type_tasks);

        Iterable<Setting_Task> setting_tasks = setting_taskrepository.findAll();
        model.addAttribute("setting_tasks",setting_tasks);
        return "task/edit-task";
    }

    @PostMapping("/edit/{id}")
    public String editpost(@PathVariable("id") Long id, @ModelAttribute("task")
    @Valid Task task, BindingResult bindingResult,
                           Course course,Type_Task type_task,Setting_Task setting_task,
                           Model model)
    {
        if (!taskrepository.existsById(id)){return "task:/task/";}
        if (bindingResult.hasErrors()){return "task/edit-task";}
        task.setId(id);
        task.setCourses1(course);
        task.setType_task(type_task);
        task.setSetting_task(setting_task);
        taskrepository.save(task);
        return "redirect:/task/{id}";
    }
}
