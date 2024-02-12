package com.ashot.musicat.dto;

import com.ashot.musicat.utils.AlbumFormat;
import com.ashot.musicat.utils.MusicGenre;

public record AlbumDTO (Long id, String title, Long artist, MusicGenre genre, AlbumFormat format){ }
