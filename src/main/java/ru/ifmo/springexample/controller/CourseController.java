package ru.ifmo.springexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.ifmo.springexample.entity.Course;
import ru.ifmo.springexample.service.CourseService;


@RequestMapping("/course")
@RestController
public class CourseController {
    private CourseService service;
    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Course> findAll(){
         return service.getRepository().findAll();
    }

    @GetMapping("/params") // ?page=NUM&size=NUM
    public Page<Course> getAllPage(@RequestParam int page, @RequestParam int size) {
        try {
            return service.getByPage(page, size);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping(value = "/{title}")
    public Iterable<Course> getCoursesByTitle(@PathVariable String title){
        try {
            return service.getCoursesByTitle(title);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public Course/*ResponseEntity<Integer>*/ addCourse(@RequestBody Course course) {
        System.out.println(course);
        service.getRepository().save(course);
        return course /*new ResponseEntity<>(course.getId(), HttpStatus.OK)*/;
    }

    /*public @ResponseBody String getString(){
        // создание строки
        return "строка";
    }*/

    /*@GetMapping(value = "/img")
    public @ResponseBody byte[] getImg(){
        // преобразование изображения в массив байт
        return new byte[20];
    }*/


}