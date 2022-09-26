package org.aadi.springbootmongodbdemo.controller;

import lombok.RequiredArgsConstructor;
import org.aadi.springbootmongodbdemo.entity.Photo;
import org.aadi.springbootmongodbdemo.service.PhotoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/photo")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/")
    public String addPhoto(@RequestParam("image") MultipartFile image) throws IOException {
        String id= photoService.addPhoto(image.getOriginalFilename(), image);
        return id;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
        Photo photo=photoService.getPhoto(id);
        Resource resource=new ByteArrayResource(photo.getPhoto().getData());

        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
