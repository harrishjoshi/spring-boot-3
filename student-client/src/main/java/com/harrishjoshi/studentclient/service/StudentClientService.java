package com.harrishjoshi.studentclient.service;

import com.harrishjoshi.studentclient.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/api/v1/student")
public interface StudentClientService {

    @PostExchange
    public Student addStudent(@RequestBody Student student);

    @GetExchange
    List<Student> getAllStudents();

    @GetExchange("{id}")
    Student findById(@PathVariable Long id);
}
