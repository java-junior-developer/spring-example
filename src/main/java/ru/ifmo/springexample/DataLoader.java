package ru.ifmo.springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.ifmo.springexample.entity.Course;
import ru.ifmo.springexample.entity.Student;
import ru.ifmo.springexample.repository.CourseRepository;
import ru.ifmo.springexample.repository.StudentRepository;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Autowired
    public DataLoader(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void run(ApplicationArguments args) {

        Course java = new Course();
        java.setTitle("java");
        java.setDuration("3.5");
        java.setStart(LocalDate.of(2022, 9, 28));
        java.setPrice("23000");

        Course python = new Course();
        python.setTitle("python");
        python.setDuration("2.5");
        python.setStart(LocalDate.of(2022, 10, 5));
        python.setPrice("21000");

        Course js = new Course();
        js.setTitle("js");
        js.setDuration("2");
        js.setStart(LocalDate.of(2022, 9, 13));
        js.setPrice("18000");

        Student gleb = new Student();
        gleb.setName("Глеб");
        gleb.setEmail("gleb@gmail.com");
        gleb.setCourse(java);

        Student anna = new Student();
        anna.setName("Анна");
        anna.setEmail("anna@gmail.com");
        anna.setCourse(java);

        Student ksenia = new Student();
        ksenia.setName("Ксения");
        ksenia.setEmail("ksenia@gmail.com");
        ksenia.setCourse(java);

        Student ivan = new Student();
        ivan.setName("Иван");
        ivan.setEmail("ivan@gmail.com");
        ivan.setCourse(python);

        java.getStudents().add(gleb);
        java.getStudents().add(anna);
        java.getStudents().add(ksenia);

        python.getStudents().add(ivan);

        courseRepository.save(java);
        courseRepository.save(python);
        courseRepository.save(js);

        studentRepository.save(gleb);
        studentRepository.save(anna);
        studentRepository.save(ksenia);
        studentRepository.save(ivan);
    }
}