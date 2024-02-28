package com.ashot.musicat.service;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.repo.ArtistRepository;
import com.ashot.musicat.repo.TrackRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import com.ashot.musicat.utils.ImageStorage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepo;
    private final ArtistRepository artistRepo;
    private final TrackRepository trackRepo;

    public AlbumServiceImpl(AlbumRepository albumRepo, ArtistRepository artistRepo, TrackRepository trackRepo) {
        this.albumRepo = albumRepo;
        this.artistRepo = artistRepo;
        this.trackRepo = trackRepo;
    }

    @Override
    public AlbumDTO getById(Long id) {
        Album album = albumRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
        return albumToAlbumDTO(album);
    }

    @Override
    public Page<AlbumDTO> getAll(int pageNo, int pageSize) {
        return albumRepo.findAll(PageRequest.of(pageNo, pageSize))
                .map(this::albumToAlbumDTO);
    }

    @Override
    public AlbumDTO albumToAlbumDTO(Album album) {
        if (album.getImageFile() != null)
            return new AlbumDTO(
                    album.getId(),
                    album.getTitle(),
                    album.getArtist().getId(),
                    album.getArtist().getName(),
                    album.getGenre(),
                    album.getFormat(),
                    "http://192.168.1.64:8080/api/album/" + album.getId() + "/image");
        else
            return new AlbumDTO(
                    album.getId(),
                    album.getTitle(),
                    album.getArtist().getId(),
                    album.getArtist().getName(),
                    album.getGenre(),
                    album.getFormat(),
                    null); }

    @Override
    public Album albumDTOtoAlbum(AlbumDTO albumDTO) {
        Album album = new Album();
        Optional<Artist> artist = artistRepo.findById(albumDTO.artist());
        if (artist.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), albumDTO.artist()));
        album.setArtist(artist.get());
        album.setTitle(albumDTO.title());
        album.setFormat(albumDTO.format());
        album.setGenre(albumDTO.genre());
        return album;
    }

    @Override
    public AlbumDTO save(AlbumDTO albumDTO, MultipartFile image) {
        Album album = albumDTOtoAlbum(albumDTO);
        if (image != null) {
            if (ImageStorage.saveAlbumImage(image))
                album.setImageFile(image.getOriginalFilename());
        }
        return albumToAlbumDTO(albumRepo.save(album));
    }

    @Override
    public AlbumDTO update(AlbumDTO updatedAlbumDTO, Long id, MultipartFile image) {
        Optional<Album> albumOptional = albumRepo.findById(id);
        if (albumOptional.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id));
        Album album = albumOptional.get();
        ImageStorage.deleteImage(album.getImageFile());

        Album updatedAlbum = albumDTOtoAlbum(updatedAlbumDTO);
        if (image != null) {
            if (ImageStorage.saveAlbumImage(image)) {
                updatedAlbum.setImageFile(image.getOriginalFilename());
            }
        }
        updatedAlbum.setId(id);
        updatedAlbum.setTracks(album.getTracks());
        return albumToAlbumDTO(albumRepo.save(updatedAlbum));
    }

    @Override
    public void delete(Long id) {
        Album album = albumRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
        if (album != null) {
            albumRepo.delete(album);
        }
    }

    @Override
    public List<Track> getAlbumTracks(Long id) {
        Album album = albumRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
        return album.getTracks();
    }

    @Override
    public Track addTrack(Long albumId, Track track) {
        Album album = albumRepo.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), albumId)));
        album.getTracks().add(track);
        albumRepo.save(album);
        return track;
    }

    @Override
    public List<Track> addTracks(Long albumId, List<Track> track) {
        Album album = albumRepo.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), albumId)));
        album.getTracks().addAll(track);
        albumRepo.save(album);
        return track;
    }

    @Override
    public void deleteTrackById(Long albumId, Long trackId) {
        Album album = albumRepo.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), albumId)));
        album.getTracks().removeIf(track -> track.getId().equals(trackId));
        albumRepo.save(album);
    }

    @Override
    public ByteArrayResource getImage(Long id) throws IOException {
        Album album = albumRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id)));
        return ImageStorage.getImage(album.getImageFile());
    }
}
