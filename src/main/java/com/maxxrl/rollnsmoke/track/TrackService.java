package com.maxxrl.rollnsmoke.track;

import com.maxxrl.rollnsmoke.smoky.Smoky;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TrackService {

    private TrackRepository trackRepository;

    public Track addTrack(final String name) {
        Track track = new Track();
        Smoky smoky = new Smoky();
        final LocalDate rolledDate = LocalDate.now();
        smoky.setName(name);
        smoky.setRolledDate(rolledDate);
        track.setSmoky(smoky);
        return track;
    }

    public void deleteTrack(final Long id) {
        trackRepository.deleteById(id);
    }

    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    public Track getTrack(final Long id) {
        return trackRepository.findById(id).orElse(null);
    }

}
