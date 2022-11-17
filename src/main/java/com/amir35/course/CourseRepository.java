package com.amir35.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir35.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public Course findById(int id);
	
	

}
