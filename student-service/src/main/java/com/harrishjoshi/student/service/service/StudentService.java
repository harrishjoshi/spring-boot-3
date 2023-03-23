package com.harrishjoshi.student.service.service;

import com.harrishjoshi.student.service.model.Student;
import com.harrishjoshi.student.service.record.StudentRecord;
import com.harrishjoshi.student.service.repository.StudentRepository;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final ObservationRegistry observationRegistry;

    public Student addStudent(StudentRecord studentRecord) {
        Student student = Student.builder().build();
        // map student record to student object
        BeanUtils.copyProperties(studentRecord, student);

        // save student to db
        log.info("data: {}", student);
        return Observation
                .createNotStarted("addStudent", observationRegistry)
                .observe(() -> studentRepository.save(student));
    }

    public List<Student> getAllStudents() {
        return Observation.createNotStarted("getAllStudents", observationRegistry)
                .observe(() -> studentRepository.findAll());
    }

    public Student findById(Long id) {
        return Observation.createNotStarted("findById", observationRegistry)
                .observe(() -> studentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Student with id %s not available.".formatted(id))));
    }
}