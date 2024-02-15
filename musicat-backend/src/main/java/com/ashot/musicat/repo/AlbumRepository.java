package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT A.tracks FROM Album A WHERE A.id = :id")
    List<Track> findAlbumTracks(Long id);

    List<Album> findByArtistId(Long id);

    void deleteAlbumsByArtistId(Long id);
}
