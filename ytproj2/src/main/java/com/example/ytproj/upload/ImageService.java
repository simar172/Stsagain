package com.example.ytproj.upload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadImage(MultipartFile mf) throws IOException;

    InputStream serveImage(String filename) throws FileNotFoundException;
}
