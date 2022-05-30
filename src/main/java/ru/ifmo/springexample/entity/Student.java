package ru.ifmo.springexample.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_students")
public class Student {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
}