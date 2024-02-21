package com.ashot.musicat.service;


import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import org.springframework.data.domain.Page;

import java.util.List;


public interface AlbumService {
    AlbumDTO getById(Long id);
    Page<AlbumDTO> getAll(int pageNo, int pageSize);
    AlbumDTO save(AlbumDTO album);
    AlbumDTO update(AlbumDTO albumDTO, Long id);
    void delete(Long id);
    List<Track> getAlbumTracks(Long id);

    Track addTrack(Long id, Track track);
    void deleteTrackById(Long albumId, Long trackId);
    AlbumDTO albumToAlbumDTO(Album album);
    Album albumDTOtoAlbum(AlbumDTO albumDTO);
}
