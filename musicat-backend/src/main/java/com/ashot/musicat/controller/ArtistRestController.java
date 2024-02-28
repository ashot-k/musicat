package com.ashot.musicat.controller;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.dto.ArtistDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.service.AlbumService;
import com.ashot.musicat.service.ArtistService;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/artist")
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.64:3000",  "http://192.168.1.80:3000"})
public class ArtistRestController {
    private final ArtistService artistService;
    private final AlbumService albumService;

    public ArtistRestController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ArtistDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "25") int pageSize) {
        return new ResponseEntity<>(artistService.getAll(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/{id}/albums")
    public ResponseEntity <List<AlbumDTO>> getAllAlbums(@PathVariable Long id){

        List<Album> albumList = artistService.getAllAlbums(id);
        List<AlbumDTO> albumDTOSList = new ArrayList<>();
        for(Album a : albumList){
            albumDTOSList.add(albumService.albumToAlbumDTO(a));
        }
        return new ResponseEntity<>(albumDTOSList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ArtistDTO> addArtist(@RequestPart("artist") ArtistDTO artist, @RequestPart(value = "image", required = false) MultipartFile image) {
        return new ResponseEntity<>(artistService.save(artist, image), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ArtistDTO> updateArtist(@RequestBody ArtistDTO artist, @PathVariable Long id) {
        return new ResponseEntity<>(artistService.update(artist, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        artistService.delete(id);
        return new ResponseEntity<>("Deleted artist with id: " + id, HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable Long id) throws IOException {
       return new ResponseEntity<>(artistService.getImage(id), HttpStatus.OK);
    }


}
