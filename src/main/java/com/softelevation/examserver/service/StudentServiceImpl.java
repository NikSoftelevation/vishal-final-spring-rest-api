package com.softelevation.examserver.service;

import com.softelevation.examserver.entity.Student;
import com.softelevation.examserver.exception.ResourceNotFoundException;
import com.softelevation.examserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, int studentId) {

        Student getStudentById = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with studentId " + studentId + "not found"));

        getStudentById.setStudentEmail(student.getStudentEmail());
        getStudentById.setStudentName(student.getStudentName());
        getStudentById.setStudentPassword(student.getStudentPassword());
        getStudentById.setStudentUserName(student.getStudentUserName());
        getStudentById.setRollNumber(student.getRollNumber());

        return studentRepository.save(getStudentById);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByStudentId(int studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with studentId " + studentId + "not found"));
    }

    @Override
    public void deleteStudentByStudentId(int studentId) {

        Student studentToDelete = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with studentId " + studentId + "not found"));
        studentRepository.delete(studentToDelete);
    }
}
