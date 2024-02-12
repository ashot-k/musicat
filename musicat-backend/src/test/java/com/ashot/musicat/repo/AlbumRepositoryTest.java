package com.ashot.musicat.repo;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository repository;

    @BeforeAll
    static void setUp(){

    }
    /*@Test
    void mustFindAllAlbumsWithoutTracks(){
        List<Track> songs1 = new ArrayList<>();
        songs1.add(new Track("ok", 2));
        songs1.add(new Track("okokokok", 90));
        List<Track> songs2 = new ArrayList<>();
        songs2.add(new Track("ok", 2));
        songs2.add(new Track("okokokok", 90));
        repository.save(new Album("ok", songs1));
        repository.save(new Album("ok 2", songs2));


        List<Album> albumsWithoutTracks = repository.findAll();

      //  albumsWithoutTracks.forEach(this::albumToAlbumDTO);
        System.out.println(albumsWithoutTracks.get(0).getSongs());
        System.out.println();

    }
    private AlbumDTO albumToAlbumDTO(Album album){
        return new AlbumDTO(album.getId(), album.getTitle(), album.getArtist().getId(), album.getGenre(), album.getFormat());
    }*/

}