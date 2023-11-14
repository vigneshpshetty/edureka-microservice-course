package com.vignesh.edurekamicroservicecourse.service;

import com.vignesh.edurekamicroservicecourse.entity.Student;
import com.vignesh.edurekamicroservicecourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        initializeData();
    }

    private void initializeData() {
        // Insert sample data when the application starts
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("Alice", "Smith");
        Student student3 = new Student("Bob", "Johnson");

        studentRepository.saveAll(List.of(student1, student2, student3));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public boolean deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Student updateStudentById(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(existingStudent -> {
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            return studentRepository.save(existingStudent);
        }).orElse(null);
    }
}
