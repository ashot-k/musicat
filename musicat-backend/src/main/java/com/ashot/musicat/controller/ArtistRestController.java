package com.ashot.musicat.controller;

import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import com.ashot.musicat.service.AlbumService;
import com.ashot.musicat.service.ArtistService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistRestController {
    private final ArtistService artistService;
    private final AlbumService albumService;

    public ArtistRestController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Artist>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
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
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.update(artist), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        artistService.delete(id);
        return new ResponseEntity<>("Deleted artist with id: " + id, HttpStatus.OK);
    }


}
