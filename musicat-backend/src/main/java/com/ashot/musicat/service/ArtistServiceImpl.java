package com.ashot.musicat.service;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.repo.ArtistRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepo;
    private final AlbumRepository albumRepository;

    public ArtistServiceImpl(ArtistRepository artistRepo, AlbumRepository albumRepository) {
        this.artistRepo = artistRepo;
        this.albumRepository = albumRepository;
    }

    @Override
    public Artist getById(Long id) {
        return artistRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), id)));
    }

    @Override
    public Page<Artist> getAll(int pageNo, int pageSize) {
        return artistRepo.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public List<Album> getAllAlbums(Long id) {
        return albumRepository.findByArtistId(id);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepo.save(artist);
    }

    @Override
    public Artist update(Artist updatedArtist, Long id) {
        if (id == null) {
            throw new ValidationException("Enter artist id");
        }

        Optional<Artist> artistOptional = artistRepo.findById(id);
        if (artistOptional.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), id));
        Artist artist = artistOptional.get();

        updatedArtist.setAlbums(artist.getAlbums());
        updatedArtist.setId(artist.getId());

        return artistRepo.save(updatedArtist);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        artistRepo.deleteById(id);
    }
}
