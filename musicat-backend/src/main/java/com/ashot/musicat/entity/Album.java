package com.ashot.musicat.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title")
    private String title;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Song> songs;

    public Album(String title, List<Song> songs) {
        this.title = title;
        this.songs = songs;
    }

    public Album() {
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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
