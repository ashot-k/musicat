package com.ashot.musicat.service;


import com.ashot.musicat.entity.Album;

import java.util.List;

public interface AlbumService {
    Album getById(Long id);
    List<Album> getAll();
    void delete(Long id);

    Album save(Album album);

}
