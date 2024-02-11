package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
