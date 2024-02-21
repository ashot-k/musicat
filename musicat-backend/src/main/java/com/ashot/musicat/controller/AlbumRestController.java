package com.ashot.musicat.controller;


import com.ashot.musicat.dto.AlbumDTO;
import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Track;
import com.ashot.musicat.service.AlbumService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")

@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.64:3000"})
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
    public ResponseEntity<AlbumDTO> addAlbum(@Valid @RequestBody AlbumDTO album){
        return new ResponseEntity<>(albumService.save(album), HttpStatus.CREATED);
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

    @PostMapping("/{id}/tracks")
    public ResponseEntity<Track> addTrack(@PathVariable Long id, @RequestBody Track track){
        return new ResponseEntity<>(albumService.addTrack(id, track), HttpStatus.CREATED);
    }

}
