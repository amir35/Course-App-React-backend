package com.amir35.profileImage;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "PROFILEIMAGE")
public class ProfileImage {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "IMAGE_ID")
    private String imageId;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "IMAGE_TYPE")
    private String imageType;

    @Lob
    @Column(name = "IMAGE_DATA")
    private byte[] data;

    public ProfileImage(String imageName, String imageType, byte[] data) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.data = data;
    }
}
