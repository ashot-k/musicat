package com.ashot.musicat.service;

import com.ashot.musicat.entity.Track;
import com.ashot.musicat.repo.TrackRepository;
import com.ashot.musicat.utils.ExceptionMessages;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepo;

    public TrackServiceImpl(TrackRepository trackRepo) {
        this.trackRepo = trackRepo;
    }

    @Override
    public Track getById(Long id) {
        return trackRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Track.class.getSimpleName(), id)));
    }

    @Override
    public Track update(Track updatedTrack, Long id) {
        Optional<Track> oldTrack = trackRepo.findById(id);
        if(oldTrack.isEmpty()){
            throw new EntityNotFoundException(ExceptionMessages.EntityNotFoundException(Track.class.getSimpleName(), id));
        }
        updatedTrack.setId(oldTrack.get().getId());
        return trackRepo.save(updatedTrack);
    }
}
