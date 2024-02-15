package com.ashot.musicat.service;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArtistService {
    Artist getById(Long id);
    Page<Artist> getAll(int pageNo, int pageSize);
    List<Album> getAllAlbums(Long id);
    Artist save(Artist artist);
    Artist update(Artist artist, Long id);
    void delete(Long id);
}
