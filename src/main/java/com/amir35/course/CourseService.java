package com.amir35.course;

import org.springframework.data.domain.Page;

public interface CourseService {

    Course getCourse(int id);

    Page<Course> getAllCourses(int pageNumber, int pageSize);

    Course addNewCourse(Course course);

    Course editCourse(Course course);

    String deleteCourse(int id);


}
