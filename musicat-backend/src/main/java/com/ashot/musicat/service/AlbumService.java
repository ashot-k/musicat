package com.ashot.musicat.service;


import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.entity.Track;

import java.util.List;

public interface AlbumService {

    AlbumDTO getById(Long id);
    List<AlbumDTO> getAll();
    Album save(Album album);
    void delete(Long id);



    List<Track> getAlbumTracks(Long id);
}
