package com.ashot.musicat.utils;

public enum AlbumFormat {
    CD("CD"),
    VINYL("Vinyl"),
    CASSETTE("Cassette"),
    DIGITAL("Digital");

    private final String format;

    AlbumFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}