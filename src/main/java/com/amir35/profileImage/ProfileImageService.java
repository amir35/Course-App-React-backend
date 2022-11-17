package com.amir35.profileImage;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileImageService {

    public String save(MultipartFile file);
}
