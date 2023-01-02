package com.amir35.course;

import com.amir35.message.CourseResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping
	public Page<Course> getAllCourses(@RequestParam int pageNumber, @RequestParam int pageSize)
	{
		System.out.println(pageNumber + " and " + pageSize);
		return courseService.getAllCourses(pageNumber,pageSize);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseData> getCourse(@PathVariable int id)
	{

		Course course =  courseService.getCourse(id);

		if(course.getCourseId() != 0)
		return new ResponseEntity<>(new CourseResponseData(course, HttpStatus.FOUND.value(), HttpStatus.NOT_FOUND.toString()), HttpStatus.OK);
		else
			return new ResponseEntity<>(new CourseResponseData(course, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString()), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<CourseResponseData> addNewCourse(@RequestBody Course course)
	{
		Course courseTemp = courseService.addNewCourse(course);
		if(courseTemp.getCourseId() != 0)
			return new ResponseEntity<>(new CourseResponseData(courseTemp, HttpStatus.CREATED.value(), HttpStatus.CREATED.toString()), HttpStatus.OK);
		else
			return new ResponseEntity<>(new CourseResponseData(courseTemp, HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.toString()), HttpStatus.OK);
	}
	
	@PutMapping
	public Course editCourse(@RequestBody Course course)
	{
		return courseService.editCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable int id)
	{
		return courseService.deleteCourse(id);
	}
	

}
