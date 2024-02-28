package com.ashot.musicat.service;

import com.ashot.musicat.dto.ArtistDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArtistService {


    Artist artistDTOToArtist(ArtistDTO artistDTO);
    ArtistDTO artistToArtistDTO(Artist artist);
    ArtistDTO getById(Long id);
    Page<ArtistDTO> getAll(int pageNo, int pageSize);
    List<Album> getAllAlbums(Long id);
    ArtistDTO save(ArtistDTO artist, MultipartFile image);
    ArtistDTO update(ArtistDTO updatedArtistDTO, Long id);
    void delete(Long id);
    ByteArrayResource getImage(Long id) throws IOException;
}
