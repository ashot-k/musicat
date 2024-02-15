package com.ashot.musicat.service;

import com.ashot.musicat.entity.Track;
import org.springframework.stereotype.Service;


public interface TrackService {

    Track getById(Long id);
    Track update(Track track, Long id);
}
