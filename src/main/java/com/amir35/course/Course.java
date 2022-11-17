package com.amir35.course;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "course")
public class Course {
	

	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQUENCE1")
	//@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_description")
	private String courseDescription;

	@Column(name = "course_image")
	private String courseImage;
	

}
