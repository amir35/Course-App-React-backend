package com.amir35.fileUpload;

import com.amir35.course.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    public void save(MultipartFile file);

    public List<Course> getAllCourses();
}
