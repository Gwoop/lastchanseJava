package com.example.lastchanse.models;

import javax.persistence.*;

@Entity
public class Setting_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String background;
    String color;

    @OneToOne(optional = true, mappedBy = "setting_task")
    private Task task;

    public Setting_Task(String background, String color, Task task) {
        this.background = background;
        this.color = color;
        this.task = task;
    }

    public Setting_Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
