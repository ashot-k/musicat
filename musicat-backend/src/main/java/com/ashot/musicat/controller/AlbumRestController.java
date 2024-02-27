package com.ashot.musicat.controller;


import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.service.AlbumService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/album")

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.64:3000", "http://192.168.1.80:3000"})
public class AlbumRestController {
    private final AlbumService albumService;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<Page<AlbumDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0")  int pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "25") int pageSize){
        return new ResponseEntity<>(albumService.getAll(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(albumService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlbumDTO> addAlbum(@Valid @RequestPart("album") AlbumDTO album, @RequestPart(value = "file") MultipartFile image){
        return new ResponseEntity<>(albumService.save(album, image), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@Valid @RequestBody AlbumDTO albumDTO, @PathVariable Long id){
        return new ResponseEntity<>(albumService.update(albumDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        albumService.delete(id);
        return new ResponseEntity<>("Deleted album with id: " + id, HttpStatus.OK);
    }

    @GetMapping("/{id}/tracks")
    public ResponseEntity<List<Track>> getAlbumTracks(@PathVariable Long id){
        return new ResponseEntity<>(albumService.getAlbumTracks(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/tracks/{trackId}")
    public ResponseEntity<String> deleteTrackById(@PathVariable Long id, @PathVariable Long trackId){
        albumService.deleteTrackById(id, trackId);
        return new ResponseEntity<>("Deleted track with id: " + trackId + " from album with id: " + id, HttpStatus.OK);
    }

    @PostMapping("/{id}/track")
    public ResponseEntity<Track> addTrack(@PathVariable Long id, @RequestBody Track track){
        return new ResponseEntity<>(albumService.addTrack(id, track), HttpStatus.CREATED);
    }
    @PostMapping("/{id}/tracks")
    public ResponseEntity<List<Track>> addTracks(@PathVariable Long id, @RequestBody List<Track> tracks){
        return new ResponseEntity<>(albumService.addTracks(id, tracks), HttpStatus.CREATED);
    }


    @GetMapping(value = "{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<ByteArrayResource> image(@PathVariable Long id) throws IOException {
        return new ResponseEntity<>(albumService.getImage(id), HttpStatus.OK);
    }
}
