package net.shakildev.demobackend.mapper;

import net.shakildev.demobackend.dto.StudentDto;
import net.shakildev.demobackend.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return  new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()

        );
    }
    public static Student mapTostudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }
}
