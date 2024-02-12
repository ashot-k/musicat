package com.ashot.musicat.service;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepository albumRepo;
    private final EntityManager em;

    public AlbumServiceImpl(AlbumRepository albumRepo, EntityManager em) {
        this.albumRepo = albumRepo;
        this.em = em;
    }

    @Override
    public AlbumDTO getById(Long id) {
        Album album = albumRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
        return  albumToAlbumDTO(album);
    }
    @Override
    public List<AlbumDTO> getAll(){
        List<Album> albums = albumRepo.findAll();
        List<AlbumDTO> albumDTOS = new ArrayList<>();
        albums.forEach(album -> {
            albumDTOS.add(new AlbumDTO(album.getId(), album.getTitle(), album.getArtist().getId(), album.getGenre(), album.getFormat()));
        });
        return albumDTOS;
    }

    private AlbumDTO albumToAlbumDTO(Album album){
        return new AlbumDTO(album.getId(), album.getTitle(), album.getArtist().getId(), album.getGenre(), album.getFormat());
    }
    @Override
    public Album save(Album album) {
        return albumRepo.save(album);
    }
    @Override
    public void delete(Long id) {
        albumRepo.deleteById(id);
    }

    @Override
    public List<Track> getAlbumTracks(Long id) {
        return albumRepo.findAlbumTracks(id);
    }


}
