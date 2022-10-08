package com.example.ytproj.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ImageServiceImpl implements ImageService {
    @Value("${project.image}")
    String imagePath;

    @Override
    public String uploadImage(MultipartFile mf) throws IOException {
        // TODO Auto-generated method stub
        File f = new File(imagePath);
        if (!f.exists()) {
            f.mkdir();
        }

        Files.copy(mf.getInputStream(),
                Path.of(imagePath +
                        File.separator +
                        mf.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING);
        return mf.getOriginalFilename();
    }

    @Override
    public InputStream serveImage(String filename) throws FileNotFoundException {
        // TODO Auto-generated method stub
        InputStream isInputStream = new FileInputStream(imagePath + File.separator + filename);
        return isInputStream;
    }

}
