package com.example.lastchanse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    String name;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    String first_name;
    @Size(message = "Строка не может быть меньше",min = 3,max = 30)
    String middle_name;
    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    User user;


    @OneToOne(optional = true, cascade = CascadeType.DETACH)
    Passport passport;


    public Person(String name, String first_name, String middle_name, User user) {
        this.name = name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.user = user;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
