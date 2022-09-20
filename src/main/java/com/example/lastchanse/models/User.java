package com.example.lastchanse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть меньше",min = 3,max = 15)
    private String username;

    private String password;
    @OneToOne(optional = true, mappedBy = "user")
    private Person person;
    @OneToOne(optional = true, mappedBy = "useroc")
    private Ochenka ochenka;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Course cour;

    public User(String username, String password, Person person, Ochenka ochenka, boolean active, Set<Role> roles, Course courses) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.ochenka = ochenka;
        this.active = active;
        this.roles = roles;
        this.cour = courses;
    }


    public User() {
    }


    public Ochenka getOchenka() {
        return ochenka;
    }

    public void setOchenka(Ochenka ochenka) {
        this.ochenka = ochenka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Course getCourses() {
        return cour;
    }

    public void setCourses(Course courses) {
        this.cour = courses;
    }
}
