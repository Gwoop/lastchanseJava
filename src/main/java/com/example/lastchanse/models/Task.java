package com.example.lastchanse.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Size(message = "Строка не может быть меньше",min = 3,max = 1000)
    String nametask;
    @Size(message = "Строка не может быть меньше",min = 3,max = 1000)
    String date;
    @Size(message = "Строка не может быть меньше",min = 3,max = 1000)
    String datesdacha;
    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    private Type_Task type_task;
    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    private Setting_Task setting_task;
    @OneToOne(optional = true, mappedBy = "taskoc")
    private Ochenka ochenka;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Course courses1;


    public Task(String nametask, String date, String datesdacha, Type_Task type_task, Setting_Task setting_task, Ochenka ochenka, Course courses1) {
        this.nametask = nametask;
        this.date = date;
        this.datesdacha = datesdacha;
        this.type_task = type_task;
        this.setting_task = setting_task;
        this.ochenka = ochenka;
        this.courses1 = courses1;
    }

    public Task() {
    }

    public Ochenka getOchenka() {
        return ochenka;
    }

    public void setOchenka(Ochenka ochenka) {
        this.ochenka = ochenka;
    }

    public Course getCourses1() {
        return courses1;
    }

    public void setCourses1(Course courses1) {
        this.courses1 = courses1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNametask() {
        return nametask;
    }

    public void setNametask(String nametask) {
        this.nametask = nametask;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDatesdacha() {
        return datesdacha;
    }

    public void setDatesdacha(String datesdacha) {
        this.datesdacha = datesdacha;
    }

    public Type_Task getType_task() {
        return type_task;
    }

    public void setType_task(Type_Task type_task) {
        this.type_task = type_task;
    }

    public Setting_Task getSetting_task() {
        return setting_task;
    }

    public void setSetting_task(Setting_Task setting_task) {
        this.setting_task = setting_task;
    }
}
