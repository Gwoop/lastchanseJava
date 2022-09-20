package com.example.lastchanse.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class Type_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    String nametypec;

    @OneToOne(optional = true, mappedBy = "type_course")
    private Course course;




}
