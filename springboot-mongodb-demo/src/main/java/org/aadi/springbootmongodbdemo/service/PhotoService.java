package org.aadi.springbootmongodbdemo.service;

import org.aadi.springbootmongodbdemo.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    String addPhoto(String originalFilename, MultipartFile image) throws IOException;
    Photo getPhoto(String id);
}
