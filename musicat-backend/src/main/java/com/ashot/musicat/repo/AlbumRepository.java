package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AlbumRepository extends JpaRepository<Album, Long> {
}
