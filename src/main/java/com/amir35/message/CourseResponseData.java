package com.amir35.message;

import com.amir35.course.Course;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CourseResponseData {

    private Course data;

    private Integer statusCode = HttpStatus.NO_CONTENT.value();

    private String statusMessage;
}
