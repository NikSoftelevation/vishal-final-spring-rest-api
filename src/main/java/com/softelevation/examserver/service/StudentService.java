package com.softelevation.examserver.service;

import com.softelevation.examserver.entity.Student;

import java.util.List;

public interface StudentService {

    public Student createNewStudent(Student student);

    public Student updateStudent(Student student, int studentId);

    public List<Student> getAllStudents();

    public Student getStudentByStudentId(int studentId);

    public void deleteStudentByStudentId(int studentId);
}