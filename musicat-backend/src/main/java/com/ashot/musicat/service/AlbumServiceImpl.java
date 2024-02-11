package com.ashot.musicat.service;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumRepository albumRepo;
    public AlbumServiceImpl(AlbumRepository albumRepo) {
        this.albumRepo = albumRepo;
    }
    @Override
    public Album getById(Long id) {
        return albumRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
    }
    @Override
    public List<Album> getAll() {
        return albumRepo.findAll();
    }
    @Override
    public Album save(Album album) {
        return albumRepo.save(album);
    }
    @Override
    public void delete(Long id) {
        albumRepo.deleteById(id);
    }


}
