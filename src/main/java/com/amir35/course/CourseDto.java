package com.amir35.course;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Course} entity
 */
@Data
public class CourseDto implements Serializable {

    private int courseId;

    private String courseName;

    private String courseDescription;

    private String courseImage;

}