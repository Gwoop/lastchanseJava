package com.example.lastchanse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Type_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    String nametype;
    @OneToOne(optional = true, mappedBy = "type_task")
    private Task task;

    public Type_Task(String nametype, Task task) {
        this.nametype = nametype;
        this.task = task;
    }

    public Type_Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
