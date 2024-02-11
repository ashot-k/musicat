package com.ashot.musicat.controller;


import com.ashot.musicat.entity.Album;
import com.ashot.musicat.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll(){
        return new ResponseEntity<>(albumService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id){
        return new ResponseEntity<>(albumService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album){
        return new ResponseEntity<>(albumService.save(album), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        albumService.delete(id);
        return new ResponseEntity<>("Deleted album with id: " + id, HttpStatus.OK);
    }

}
