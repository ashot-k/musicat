package com.ashot.musicat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "Enter a name")
    private String name;
    @Column(length = 25000)
    private String description;
    private String members;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;

    private String imageFile;
    @Transient
    public static final String IMAGE_FILE_PREFIX = "artist_image_";

    public Artist() {
    }

    public Artist(String name, String description, String members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public Artist(String name, String description, String members, List<Album> albums) {
        this.name = name;
        this.description = description;
        this.members = members;
        this.albums = albums;
    }

    public Artist(String name, String description, String members, String imageFile) {
        this.name = name;
        this.description = description;
        this.members = members;
        this.imageFile = imageFile;
    }

    public Artist(String name, String description, String members, List<Album> albums, String imageFile) {
        this.name = name;
        this.description = description;
        this.members = members;
        this.albums = albums;
        this.imageFile = imageFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public String getImageFile() {
            return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = IMAGE_FILE_PREFIX + imageFile;
    }
}
