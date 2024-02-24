package net.shakildev.demobackend.controller;

import lombok.AllArgsConstructor;
import net.shakildev.demobackend.entity.Course;
import net.shakildev.demobackend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class CourseController {

    private CourseService courseService;

   @PostMapping("/postCourse")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
       Course postCourse= courseService.postCourse(course);
       return  new ResponseEntity<>(postCourse, HttpStatus.OK);
    }

}
