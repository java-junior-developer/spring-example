package ru.ifmo.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ifmo.springexample.entity.Course;
import ru.ifmo.springexample.entity.Student;
import ru.ifmo.springexample.repository.CourseRepository;

import java.time.LocalDate;

@SpringBootApplication
public class SpringExampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleProjectApplication.class, args);
	}

}
