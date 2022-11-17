package com.amir35.course;

import com.amir35.message.CourseResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	public CourseResponseData getCourse(int id) {

		Optional<Course> courseOptional = Optional.ofNullable(courseRepo.findById(id));

		if(courseOptional.isPresent()) {
			return new CourseResponseData(courseOptional, HttpStatus.OK.value());
		}else {
			return Optional.of(new Course(0, null, null, null));
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
		// TODO Auto-generated method stub
		System.out.println(course);
		return courseRepo.save(course);
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
