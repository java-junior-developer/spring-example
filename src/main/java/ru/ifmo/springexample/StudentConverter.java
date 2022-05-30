package ru.ifmo.springexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.ifmo.springexample.entity.Student;

import java.io.IOException;

@Component
public class StudentConverter implements Converter<String, Student> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Student convert(String source) {
        try {
            return objectMapper.readValue(source, Student.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}