package com.example.lastchanse.models;

import javax.persistence.*;


@Entity
public class Ochenka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String data;
    String ochenka;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    User useroc;

    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    Task taskoc;

    public Ochenka(String data, String ochenka, User useroc, Task taskoc) {
        this.data = data;
        this.ochenka = ochenka;
        this.useroc = useroc;
        this.taskoc = taskoc;
    }

    public Ochenka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOchenka() {
        return ochenka;
    }

    public void setOchenka(String ochenka) {
        this.ochenka = ochenka;
    }

    public User getUseroc() {
        return useroc;
    }

    public void setUseroc(User useroc) {
        this.useroc = useroc;
    }

    public Task getTaskoc() {
        return taskoc;
    }

    public void setTaskoc(Task taskoc) {
        this.taskoc = taskoc;
    }
}
