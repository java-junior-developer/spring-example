package ru.ifmo.springexample.specifications;


import org.springframework.data.jpa.domain.Specification;
import ru.ifmo.springexample.entity.Course;


public class CourseSpecifications {

    // SELECT * FROM tb_courses WHERE title = :courseTitle
    public static Specification<Course> coursesByTitle(String courseTitle) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), courseTitle);
    }

    // SELECT c FROM Course c WHERE c.title LIKE %:param%
    public static Specification<Course> coursesLikeTitle(String courseTitle) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), courseTitle);
    }

}