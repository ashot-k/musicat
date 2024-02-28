package com.ashot.musicat.service;

import com.ashot.musicat.dto.ArtistDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.repo.AlbumRepository;
import com.ashot.musicat.repo.ArtistRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import com.ashot.musicat.utils.ImageStorage;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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
    public ArtistDTO getById(Long id) {
        return artistRepo.findById(id).map(this::artistToArtistDTO)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), id)));
    }

    @Override
    public Page<ArtistDTO> getAll(int pageNo, int pageSize) {
        return artistRepo.findAll(PageRequest.of(pageNo, pageSize)).map(this::artistToArtistDTO);
    }

    @Override
    public List<Album> getAllAlbums(Long id) {
        return albumRepository.findByArtistId(id);
    }

    @Override
    public Artist artistDTOToArtist(ArtistDTO artistDTO){
        Artist artist = new Artist();
        artist.setId(artistDTO.id());
        artist.setName(artistDTO.name());
        artist.setDescription(artistDTO.description());
        artist.setMembers(artistDTO.members());
        return artist;
    }
    @Override
    public ArtistDTO artistToArtistDTO(Artist artist){
        if(artist.getImageFile() != null)
            return new ArtistDTO(
                    artist.getId(),
                    artist.getName(),
                    artist.getDescription(),
                    artist.getMembers(),
                    "http://192.168.1.64:8080/api/artist/" + artist.getId() + "/image");
        else
            return new ArtistDTO(
                artist.getId(),
                artist.getName(),
                artist.getDescription(),
                artist.getMembers(),
                null);
    }
    @Override
    public ArtistDTO save(ArtistDTO artistDTO, MultipartFile image) {
        Artist artist = artistDTOToArtist(artistDTO);
        if (image != null) {
            if (ImageStorage.saveArtistImage(image))
                artist.setImageFile(image.getOriginalFilename());
        }
        return artistToArtistDTO(artistRepo.save(artist));
    }

    @Override
    public ArtistDTO update(ArtistDTO updatedArtistDTO, Long id) {
        if (id == null) {
            throw new ValidationException("Enter artist id");
        }
        Optional<Artist> artistOptional = artistRepo.findById(id);
        if (artistOptional.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), id));
        Artist artist = artistOptional.get();
        Artist updatedArtist = artistDTOToArtist(updatedArtistDTO);
        updatedArtist.setId(artist.getId());
        return artistToArtistDTO(artistRepo.save(updatedArtist));
    }

    @Override
    public void delete(Long id) {
        artistRepo.deleteById(id);
    }
    @Override
    public ByteArrayResource getImage(Long id) throws IOException {
        Artist artist =  artistRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Artist.class.getSimpleName(), id)));
        return ImageStorage.getImage(artist.getImageFile());
    }
}
