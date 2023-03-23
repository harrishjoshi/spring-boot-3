package com.harrishjoshi.student.service.controller;

import com.harrishjoshi.student.service.model.Student;
import com.harrishjoshi.student.service.record.StudentRecord;
import com.harrishjoshi.student.service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentServiceController {

    private final StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody StudentRecord studentRecord) {
        return studentService.addStudent(studentRecord);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }
}
