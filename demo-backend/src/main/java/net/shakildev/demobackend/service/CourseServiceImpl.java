package net.shakildev.demobackend.service;

import lombok.AllArgsConstructor;
import net.shakildev.demobackend.entity.Course;
import net.shakildev.demobackend.repository.CourseRepository;
import net.shakildev.demobackend.repository.StudentRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;
    @Override
    public Course postCourse(Course course) {
        Course course1=courseRepository.save(course);
        return course1;
    }
}
