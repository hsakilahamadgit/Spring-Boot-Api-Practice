package net.shakildev.demobackend.repository;

import net.shakildev.demobackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
    Student findByFirstName(String firstName);
    Student findByFirstNameAndLastName(String firstName,String lastName);

    //using native query
    @Query(value = "select * from students where id=?",nativeQuery = true)
    Student findStudentByIdUsingNative(Long id);

    //using jpql
    @Query("select s from Student s where s.id=:id")
    Student findStudentByIdJpql(Long id);
}
