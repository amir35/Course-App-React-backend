package com.amir35.course;

import com.amir35.course.Course;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CourseService {

    public Optional<Course> getCourse(int id);

    public Page<Course> getAllCourses(int pageNumber, int pageSize);

    public Course addNewCourse(Course course);

    public Course editCourse(Course course);

    public String deleteCourse(int id);


}
