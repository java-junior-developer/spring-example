package ru.ifmo.springexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ifmo.springexample.entity.Course;
import ru.ifmo.springexample.repository.CourseRepository;
import ru.ifmo.springexample.specifications.CourseSpecifications;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseRepository getRepository() {
        return repository;
    }

    public Page<Course> getByPage(int page, int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursePage = repository.findAll(pageable);
        if (coursePage.getContent().isEmpty()) throw new Exception("Записи не были найдены");
        return coursePage;
    }
    public List<Course> getCoursesByTitle(String title) throws Exception {
        List<Course> courses = repository.findAll(CourseSpecifications.coursesByTitle(title));
        if (courses.isEmpty()) throw new Exception("Записи не были найдены");
        return courses;
    }
}