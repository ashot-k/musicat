package com.ashot.musicat.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ImageStorage {

    @Value("${image-storage.location.unix}")
    public String imageStoragePath;
    @Value("${image-storage.location.windows}")
    public String imageStoragePathWindows;

    public static String currentStoragePath;

    public static ByteArrayResource getImage(String imageFile) throws IOException {
        File folder = new File(ImageStorage.currentStoragePath);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                if (f.getName().trim().equalsIgnoreCase(imageFile)) {
                    return new ByteArrayResource(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
                }
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        String path = imageStoragePath;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            path = imageStoragePathWindows;
        }
        File imageStorageDirectory = new File(path);
        if (imageStorageDirectory.mkdirs()) {
            System.out.println("Image storage directory created successfully.");
        } else {
            System.out.println("Image storage directory already exists.");
        }
        currentStoragePath = path;
    }

    public static boolean saveImage(MultipartFile imageFile) {
        File image = new File(currentStoragePath + "\\" + imageFile.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(image)) {
            os.write(imageFile.getBytes());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
