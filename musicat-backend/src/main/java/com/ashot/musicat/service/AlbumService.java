package com.ashot.musicat.service;


import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface AlbumService {
    AlbumDTO getById(Long id);
    Page<AlbumDTO> getAll(int pageNo, int pageSize);
    AlbumDTO save(AlbumDTO album, MultipartFile image);
    AlbumDTO update(AlbumDTO albumDTO, Long id, MultipartFile image);
    void delete(Long id);
    List<Track> getAlbumTracks(Long id);

    Track addTrack(Long id, Track track);
    List<Track> addTracks(Long id, List<Track> track);
    void deleteTrackById(Long albumId, Long trackId);

    ByteArrayResource getImage(Long id) throws IOException;
    AlbumDTO albumToAlbumDTO(Album album);
    Album albumDTOtoAlbum(AlbumDTO albumDTO);
}
