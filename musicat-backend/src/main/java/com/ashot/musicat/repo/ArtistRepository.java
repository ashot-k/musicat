package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Album;
import com.ashot.musicat.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
