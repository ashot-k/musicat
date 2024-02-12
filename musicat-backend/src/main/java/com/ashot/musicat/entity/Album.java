package com.ashot.musicat.entity;

import com.ashot.musicat.utils.AlbumFormat;
import com.ashot.musicat.utils.MusicGenre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull(message = "Please enter an album title")
    @NotBlank(message = "Please enter an album title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Track> tracks;
    @Enumerated(STRING)
    private AlbumFormat format;
    @Enumerated(STRING)
    private MusicGenre genre;

    public Album(String title, List<Track> tracks) {
        this.title = title;
        this.tracks = tracks;
    }

    public Album(String title, Artist artist, List<Track> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public Album(String title, Artist artist, List<Track> tracks, AlbumFormat format, MusicGenre genre) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.format = format;
        this.genre = genre;
    }

    public Album(Long id, String title, List<Track> tracks) {
        this.id = id;
        this.title = title;
        this.tracks = tracks;
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

    public AlbumFormat getFormat() {
        return format;
    }

    public void setFormat(AlbumFormat format) {
        this.format = format;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public List<Track> getSongs() {
        return tracks;
    }

    public void setSongs(List<Track> tracks) {
        this.tracks = tracks;
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
