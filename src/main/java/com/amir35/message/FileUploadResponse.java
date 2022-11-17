package com.amir35.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class FileUploadResponse {

    private String name;

    private String url;

    private String type;

    private long size;

}
