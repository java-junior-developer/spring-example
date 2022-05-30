package ru.ifmo.springexample.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ifmo.springexample.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
}