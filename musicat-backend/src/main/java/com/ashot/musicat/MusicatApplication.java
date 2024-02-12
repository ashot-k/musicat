package com.ashot.musicat;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.service.AlbumService;
import com.ashot.musicat.utils.AlbumFormat;
import com.ashot.musicat.utils.MusicGenre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MusicatApplication{
    public static void main(String[] args) {
        System.out.println(MusicGenre.genres);
        System.out.println(AlbumFormat.formats);
        SpringApplication.run(MusicatApplication.class, args);
    }

}
