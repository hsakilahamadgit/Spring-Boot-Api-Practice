package net.shakildev.demobackend.controller;

import lombok.AllArgsConstructor;
import net.shakildev.demobackend.dto.StudentDto;
import net.shakildev.demobackend.entity.Student;
import net.shakildev.demobackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {


    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto saveStudent=studentService.createStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);

    }
    @PostMapping("/createStudentWoDto")
    public ResponseEntity<Student> createStudentWoDto(@RequestBody Student student){
        Student saveStudent =studentService.createStudent2(student);

        return new ResponseEntity<>(saveStudent,HttpStatus.OK);
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){

        Student student =studentService.getStudentById(id);
            return new ResponseEntity<>(student,HttpStatus.OK);
    }
@GetMapping("/getAllStudent")
    public  ResponseEntity<List<Student>> getAllStudent(){
         List<Student> students=studentService.getAllStudents();
         return new ResponseEntity<List<Student>>(students,HttpStatus.OK);

    }

    @PostMapping("/saveAllStudent")
    public  ResponseEntity<List<Student>> saveAllStudent(@RequestBody List<Student> studentList){
        List<Student> students=studentService.saveAllStudents(studentList);
        ResponseEntity<List<Student>> listResponseEntity = new ResponseEntity<>(students, HttpStatus.CREATED);
        System.out.println(listResponseEntity.getHeaders());
        System.out.println(listResponseEntity.getBody());
        return listResponseEntity;
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Student> updateById(@PathVariable Long id ,@RequestBody Student student){
        Student updatedStudent=studentService.updateStudentById(id,student);

        return new  ResponseEntity<Student>(updatedStudent,HttpStatus.OK);

    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void>deleteBuId(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Student>getStudentByEmailId(@PathVariable String email){
        Student student = studentService.fndStudentByEmailId(email);
     return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/byFirstName/{firstName}")
    public ResponseEntity<Student>findByFirstName(@PathVariable String firstName){
        Student getStudentByFirstName=studentService.findStudentByFirstName(firstName);

        return new ResponseEntity<>(getStudentByFirstName,HttpStatus.OK);
    }
    @GetMapping("/byFirstNameAndLastName/{firstName}/{lastName}")
    public ResponseEntity<Student>findStudentByFirstNameAndLastName(@PathVariable String firstName ,@PathVariable String lastName){
        Student studentByFirstNameAndLastName=studentService.findStudentByFirstNameAndLastName(firstName,lastName);

        return new ResponseEntity<>(studentByFirstNameAndLastName,HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Student>findStudentByFirstNameAndLastName(@PathVariable Long id){
        Student findById=studentService.findStudentById(id);

        return new ResponseEntity<>(findById,HttpStatus.OK);
    }

    @GetMapping("/findByIdJpql/{id}")
    public  ResponseEntity<Student> findStudentUsingJpql(@PathVariable Long id){
       Student studentUsingJpql= studentService.findStudentUsingJpql(id);

       return new  ResponseEntity<>(studentUsingJpql,HttpStatus.OK);

    }
}
