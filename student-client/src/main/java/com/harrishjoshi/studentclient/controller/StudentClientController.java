package com.harrishjoshi.studentclient.controller;

import com.harrishjoshi.studentclient.model.Student;
import com.harrishjoshi.studentclient.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student-client")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentClientService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentClientService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable Long id) {
        try {
            return studentClientService.findById(id);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Student with id %s not available.".formatted(id));
        }
    }
}