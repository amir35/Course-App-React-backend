package com.amir35.course;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	public Course getCourse(int id) {

		Optional<Course> courseOptional = Optional.ofNullable(courseRepo.findById(id));

		if(courseOptional.isPresent()) {
			return courseOptional.get();
		}else {
			return new Course();
		}
	}
	public Page<Course> getAllCourses(int pageNumber, int pageSize)
	{
		
		System.out.println(pageNumber + " and " + pageSize);
		Pageable pg = PageRequest.of(pageNumber, pageSize);
		
		Page<Course> page = courseRepo.findAll(pg);
		
		return page;
	}


	public Course addNewCourse(Course course) {


		Course courseTemp = courseRepo.save(course);

		if(courseTemp != null)
		{
			return courseTemp;
		}else {
			return new Course();
		}
	}


	public Course editCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}


	public String deleteCourse(int id) {

		courseRepo.deleteById(id);
		
		return "Course Deleted";
		
	}

}
