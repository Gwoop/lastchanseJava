package com.example.lastchanse.models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    String namecourse;
    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    private Setting_Course setting_course;
    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    private Type_Course type_course;
    @OneToMany(mappedBy = "cour", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<User> users;
    @OneToMany(mappedBy = "courses1", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Task> taskss;


    public Course(String namecourse, Setting_Course setting_course, Type_Course type_course, Collection<User> users, Collection<Task> tasks) {
        this.namecourse = namecourse;
        this.setting_course = setting_course;
        this.type_course = type_course;
        this.users = users;
        this.taskss = tasks;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

    public Setting_Course getSetting_course() {
        return setting_course;
    }

    public void setSetting_course(Setting_Course setting_course) {
        this.setting_course = setting_course;
    }

    public Type_Course getType_course() {
        return type_course;
    }

    public void setType_course(Type_Course type_course) {
        this.type_course = type_course;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Task> getTasks() {
        return taskss;
    }

    public void setTasks(Collection<Task> tasks) {
        this.taskss = tasks;
    }
}
