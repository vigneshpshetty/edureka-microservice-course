package com.vignesh.edurekamicroservicecourse.repository;

import com.vignesh.edurekamicroservicecourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    Optional<Student> findAllById(Long id);
}