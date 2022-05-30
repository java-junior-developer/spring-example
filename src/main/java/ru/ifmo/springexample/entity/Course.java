package ru.ifmo.springexample.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Entity
@Table(name = "tb_courses")
public class Course {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(length = 100, nullable = false)
    private String title;

    @Getter
    @Setter
    private LocalDate start;
    @Getter
    @Setter
    private String price;

    @Getter
    @Setter
    private String duration;

    @Getter
    @Setter
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Student> students = new HashSet<>();
}