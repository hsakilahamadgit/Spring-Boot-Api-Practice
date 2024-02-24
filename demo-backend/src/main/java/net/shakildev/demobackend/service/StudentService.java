package net.shakildev.demobackend.service;

import net.shakildev.demobackend.dto.StudentDto;
import net.shakildev.demobackend.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    Student createStudent2(Student student);

    Student getStudentById(Long id);

   List<Student> getAllStudents();

   List<Student>saveAllStudents(List<Student> studentList);
   Student updateStudentById(Long id,Student student);

   void deleteById(Long id);

   Student fndStudentByEmailId(String emailId);

   Student findStudentByFirstName (String firstName);

   Student findStudentByFirstNameAndLastName(String firstName,String lastName);

   Student findStudentById(Long id);

   Student findStudentUsingJpql(Long id);

}
