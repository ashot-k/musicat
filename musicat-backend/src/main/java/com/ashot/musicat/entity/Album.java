package com.ashot.musicat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.mapping.Join;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull(message = "Please enter an album title")
    @NotBlank(message = "Please enter an album title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Track> tracks;
    private String format;
    private String genre;

    public Album(String title, Artist artist, List<Track> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public Album(String title, Artist artist, List<Track> tracks, String format, String genre) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.format = format;
        this.genre = genre;
    }
    public Album(String title, Artist artist, String format, String genre) {
        this.title = title;
        this.artist = artist;
        this.format = format;
        this.genre = genre;
    }
    public Album(Long id, String title, Artist artist, String format, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.format = format;
        this.genre = genre;
    }


    public Album(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Album(String title) {
        this.title = title;
    }

    public Album() {
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
