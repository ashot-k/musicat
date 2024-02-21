package com.ashot.musicat.service;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.repo.ArtistRepository;
import com.ashot.musicat.repo.TrackRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    public AlbumDTO albumToAlbumDTO(Album album) {
        return new AlbumDTO(album.getId(), album.getTitle(), album.getArtist().getId(), album.getArtist().getName(), album.getGenre(), album.getFormat());
    }

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
    public AlbumDTO save(AlbumDTO albumDTO) {
        Album album = albumDTOtoAlbum(albumDTO);
        return albumToAlbumDTO(albumRepo.save(album));
    }

    @Override
    public AlbumDTO update(AlbumDTO albumDTO, Long id) {
        Optional<Album> albumOptional = albumRepo.findById(id);
        if (albumOptional.isEmpty()) {
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), id));
        }
        Album album = albumOptional.get();
        Album updatedAlbum = albumDTOtoAlbum(albumDTO);
        updatedAlbum.setId(id);
        updatedAlbum.setTracks(album.getTracks());
        album = updatedAlbum;

        return albumToAlbumDTO(albumRepo.save(album));
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
    public void deleteTrackById(Long albumId, Long trackId) {
        Album album = albumRepo.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Album.class.getSimpleName(), albumId)));
        album.getTracks().removeIf(track -> track.getId().equals(trackId));
        albumRepo.save(album);
    }
}
