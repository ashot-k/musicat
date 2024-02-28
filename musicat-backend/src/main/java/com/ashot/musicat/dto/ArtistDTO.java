package com.ashot.musicat.dto;

import com.ashot.musicat.entity.Album;

import java.util.List;

public record ArtistDTO (Long id,
                         String name,
                         String description,
                         String members,
                         String imageURL){

}
