package net.shakildev.demobackend.repository;

import net.shakildev.demobackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
