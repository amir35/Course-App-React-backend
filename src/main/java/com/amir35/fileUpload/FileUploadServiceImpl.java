package com.amir35.fileUpload;

import java.io.IOException;
import java.util.List;

import com.amir35.course.Course;
import com.amir35.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    CourseRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Course> course = FileUploadHelper.excelToCourses(file.getInputStream());
            repository.saveAll(course);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }
}
