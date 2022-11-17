package com.amir35.profileImage;

import com.amir35.message.FileUploadMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class ProfileImageController {

    @Autowired
    private ProfileImageService imageUploadService;

    @PostMapping("/image/upload")
    public ResponseEntity<FileUploadMessage> uploadImage(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ProfileImageHelper.hasImageFormat(file)) {
            System.out.print("has image jpg/png format");
            try {
                imageUploadService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new FileUploadMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileUploadMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FileUploadMessage(message));
    }

    /*@GetMapping("/course")
    public ResponseEntity<List<Course>> getAllTutorials() {
        try {
            List<Course> courses = fileService.getAllCourses();

            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}