package com.ashot.musicat.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class ImageStorage {

    @Value("${image-storage.location}")
    public static String imageStoragePath;

    @PostConstruct
    public void init(){
        File imageStorageDirectory = new File(imageStoragePath);
        if(imageStorageDirectory.mkdirs()){

        }



    }

    public static boolean saveImage(MultipartFile file){



        return true;
    }

}
