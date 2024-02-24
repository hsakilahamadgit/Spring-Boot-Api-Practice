package net.shakildev.demobackend.service;

import lombok.AllArgsConstructor;
import net.shakildev.demobackend.dto.StudentDto;
import net.shakildev.demobackend.entity.Student;
import net.shakildev.demobackend.mapper.StudentMapper;
import net.shakildev.demobackend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= StudentMapper.mapTostudent(studentDto);
        System.out.println("student--->"+student);
        Student saveStudent=studentRepository.save(student);
        StudentDto studentDto1= StudentMapper.mapToStudentDto(saveStudent);
        return studentDto1;
    }

    @Override
    public Student createStudent2(Student student) {
        Student st=studentRepository.save(student);
        return  st;

    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(()->new RuntimeException("No such element"));
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }

    @Override
    public List<Student> saveAllStudents(List<Student> studentList) {
         List<Student> studentList1=studentRepository.saveAll(studentList);
        return studentList1;
    }

    @Override
    public Student updateStudentById(Long id, Student student) {
        Optional<Student> studentOptional=studentRepository.findById(id);
        Student existingStudent=studentOptional.orElseThrow();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
       Student updatedStudent= studentRepository.save(existingStudent);


        return updatedStudent;
    }

    @Override
    public void deleteById(Long id) {
         studentRepository.deleteById(id);
        return;
    }

    @Override
    public Student fndStudentByEmailId(String emailId) {
        return studentRepository.findByEmail(emailId);

    }

    @Override
    public Student findStudentByFirstNameAndLastName(String firstName, String lastName) {
          Student student=studentRepository.findByFirstNameAndLastName(firstName,lastName);
        return student;
    }

    @Override
    public Student findStudentById(Long id) {
        Student studentByIdUsingNative=studentRepository.findStudentByIdUsingNative(id);

        return studentByIdUsingNative;
    }

    @Override
    public Student findStudentUsingJpql(Long id) {
        Student studentByIdJpql=studentRepository.findStudentByIdJpql(id);
        return studentByIdJpql;
    }


    @Override
    public Student findStudentByFirstName(String firstName) {

        Student studentFirstName=studentRepository.findByFirstName(firstName);
        return studentFirstName;
    }
}
