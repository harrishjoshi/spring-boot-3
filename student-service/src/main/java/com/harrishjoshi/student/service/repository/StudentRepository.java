package com.harrishjoshi.student.service.repository;

import com.harrishjoshi.student.service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
