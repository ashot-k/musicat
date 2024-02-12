package com.ashot.musicat.utils;

public enum MusicGenre {
    ROCK("Rock"),
    POP("Pop"),
    RAP("Rap"),
    COUNTRY("Country"),
    JAZZ("Jazz"),
    BLUES("Blues"),
    CLASSICAL("Classical"),
    ELECTRONIC("Electronic"),
    HIP_HOP("Hip Hop"),
    R_AND_B("R&B"),
    REGGAE("Reggae"),
    METAL("Metal"),
    FUNK("Funk"),
    SOUL("Soul"),
    INDIE("Indie"),
    PUNK("Punk"),
    ALTERNATIVE("Alternative"),
    FOLK("Folk"),
    EDM("EDM"),  // Electronic Dance Music
    COUNTRY_ROCK("Country Rock");

    private final String genre;

    MusicGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}