package com.amir35.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
	
	@PostMapping
	public Course addNewCourse(@RequestBody Course course)
	{
		return courseService.addNewCourse(course);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable int id)
	{
		Optional<Course> course = courseService.getCourse(id);

		if (course.isPresent()) {
			return new ResponseEntity<>(course.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
