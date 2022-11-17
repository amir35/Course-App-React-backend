package com.amir35.fileUpload;

import java.util.List;
import com.amir35.course.Course;
import com.amir35.message.FileUploadMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileUploadMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (FileUploadHelper.hasExcelFormat(file)) {
            System.out.print("has excel format");
            try {
                fileService.save(file);

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

    @GetMapping("/course")
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
    }
}