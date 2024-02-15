package com.ashot.musicat.controller;


import com.ashot.musicat.entity.Track;
import com.ashot.musicat.service.TrackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/track")
public class TrackRestController {
    private final TrackService trackService;

    public TrackRestController(TrackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable Long id){
        return new ResponseEntity<>(trackService.getById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Track> update(@Valid @RequestBody Track updatedTrack, @PathVariable Long id){
        return new ResponseEntity<>(trackService.update(updatedTrack, id), HttpStatus.CREATED);
    }









}
