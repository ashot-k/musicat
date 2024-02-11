package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Album;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AlbumRepositoryTest {

    @Autowired AlbumRepository albumRepository;

    @Test
    public void saveAlbumTest(){
        Album album1 = new Album("ok123", null);
        Assert.assertNotNull(albumRepository.save(album1));
        Album album = albumRepository.findById(1L).get();
        Assert.assertNotNull(album);
        System.out.println(album.getTitle());
    }
}