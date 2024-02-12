package com.ashot.musicat.repo;

import com.ashot.musicat.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
