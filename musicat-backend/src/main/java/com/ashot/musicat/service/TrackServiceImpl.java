package com.ashot.musicat.service;

import com.ashot.musicat.repo.TrackRepository;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepo;

    public TrackServiceImpl(TrackRepository trackRepo) {
        this.trackRepo = trackRepo;
    }
}
