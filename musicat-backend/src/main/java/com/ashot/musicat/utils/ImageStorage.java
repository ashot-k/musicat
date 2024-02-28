package com.ashot.musicat.utils;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
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

    public static boolean saveAlbumImage(MultipartFile imageFile){
        return saveImage(imageFile, Album.IMAGE_FILE_PREFIX + imageFile.getOriginalFilename());
    }
    public static boolean saveArtistImage(MultipartFile imageFile){
        return saveImage(imageFile, Artist.IMAGE_FILE_PREFIX + imageFile.getOriginalFilename());
    }

    private static boolean saveImage(MultipartFile imageFile, String fileName) {
        File image = new File(currentStoragePath + "\\" + fileName);

        try (OutputStream os = new FileOutputStream(image)) {
            os.write(imageFile.getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public static boolean deleteImage(String imageFileName){
        File image = new File(currentStoragePath + "\\" + imageFileName);
        return image.delete();
    }

}
