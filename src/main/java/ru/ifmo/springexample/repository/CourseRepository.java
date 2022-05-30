package ru.ifmo.springexample.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.ifmo.springexample.entity.Course;

import java.util.List;

public interface CourseRepository extends
        PagingAndSortingRepository<Course, Integer> /*CrudRepository<Course, Integer> */,
        JpaSpecificationExecutor<Course>
{
    /*@Query(value = "SELECT * FROM tb_courses WHERE UPPER(title) = UPPER(:courseTitle)", nativeQuery = true)
    List<Course> getCoursesByTitle(String courseTitle);

    @Query("SELECT c FROM Course c WHERE c.title LIKE %:param%")
    Iterable<Course> findLikeTitle(@Param("param") String courseTitle);*/
}