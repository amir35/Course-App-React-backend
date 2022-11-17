package com.amir35.profileImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {
    @Autowired
    ProfileImageRepository repository;

    public String save(MultipartFile file) {
        try {
           // List<Course> course = ImageUploadHelper.excelToCourses(file.getInputStream());

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            ProfileImage profileImage = new ProfileImage(fileName, file.getContentType(), file.getBytes());

            repository.save(profileImage);

            return "Image data saved";
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    //public List<Course> getAllCourses() {
        //return repository.findAll();
    //}
}
