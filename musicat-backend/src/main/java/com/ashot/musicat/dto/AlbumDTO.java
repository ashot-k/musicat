package com.ashot.musicat.dto;

import com.ashot.musicat.utils.AlbumFormat;
import com.ashot.musicat.utils.MusicGenre;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.multipart.MultipartFile;

public record AlbumDTO(Long id,
                       @NotNull(message = "Enter a title")
                       String title,
                       @NotNull(message = "Enter a valid artist id")
                       Long artist,
                       String artistName,
                       @NotNull(message = "Enter a genre")
                       @NotBlank(message = "Enter a genre")
                       String genre,
                       @NotNull(message = "Enter a format")
                       @NotBlank(message = "Enter a format")
                       String format,
                       String imageURL) {
    public AlbumDTO {
        boolean flag = false;
        if (format != null) {
            for (String str : AlbumFormat.formats) {
                if (format.equalsIgnoreCase(str)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                throw new ValidationException("Invalid Format");
            }
        }
        if (genre != null) {
            flag = false;
            for (String str : MusicGenre.genres) {
                if (genre.equalsIgnoreCase(str)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                throw new ValidationException("Invalid Genre");
            }
        }
    }

}
