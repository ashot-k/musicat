package com.ashot.musicat;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Song;
import com.ashot.musicat.service.AlbumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MusicatApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MusicatApplication.class, args);
    }

 /*   private final AlbumService albumService;

    public MusicatApplication(AlbumService albumService) {
        this.albumService = albumService;
    }
*/
    @Override
    public void run(String... args){
        List<Song> songs1 = new ArrayList<>();
        songs1.add(new Song("ok", 2));
        songs1.add(new Song("okokokok", 90));

        List<Song> songs2 = new ArrayList<>();
        songs2.add(new Song("ok", 2));
        songs2.add(new Song("okokokok", 90));
     /*   albumService.save(new Album("ok", songs1));
        albumService.save(new Album("ok 2", songs2));*/
    }
}
