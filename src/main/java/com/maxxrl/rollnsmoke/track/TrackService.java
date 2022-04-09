package com.maxxrl.rollnsmoke.track;

import com.maxxrl.rollnsmoke.smoky.Smoky;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public Track addTrack(final String name) {
        Track track = new Track();
        Smoky smoky = new Smoky();
        final LocalDate rolledDate = LocalDate.now();
        smoky.setName(name);
        smoky.setRolledDate(rolledDate);
        track.setSmoky(smoky);
        trackRepository.save(track);
        return track;
    }

    public void deleteTrack(final Long id) {
        try {
            trackRepository.deleteById(id);
        } catch (Exception e) {
            throw new TrackNotFoundException("Could not find track with id " + id);
        }
    }

    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    public Track getTrack(final Long id) {
        return trackRepository.findById(id).orElseThrow(() -> new TrackNotFoundException("Could not find track with id " + id));
    }

}
