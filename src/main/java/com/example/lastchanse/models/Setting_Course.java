package com.example.lastchanse.models;

import javax.persistence.*;

@Entity
public class Setting_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String background;
    String color;

    @OneToOne(optional = true, mappedBy = "setting_course")
    private Course course;

}
