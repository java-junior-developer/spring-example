package ru.ifmo.springexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.springexample.entity.Course;
import ru.ifmo.springexample.entity.Student;
import ru.ifmo.springexample.repository.CourseRepository;
import ru.ifmo.springexample.repository.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestParam Student student, @RequestParam Integer courseId) {
        System.out.println(student);
        System.out.println("courseId: " + courseId);
        Course course = courseRepository.findById(courseId).get();
        student.setCourse(course);
        studentRepository.save(student);
        return student;
    }

}