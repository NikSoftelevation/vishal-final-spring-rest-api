package com.softelevation.examserver.controller;

import com.softelevation.examserver.entity.Student;
import com.softelevation.examserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> createsStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createNewStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(Student student, @PathVariable("studentId") int studentId) {
        Student updatedStudent = studentService.updateStudent(student, studentId);
        return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") int studentId) {
        Student studentById = studentService.getStudentByStudentId(studentId);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") int studentId) {
        studentService.deleteStudentByStudentId(studentId);
    }
}
