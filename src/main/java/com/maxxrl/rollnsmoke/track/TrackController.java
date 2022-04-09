package com.maxxrl.rollnsmoke.track;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/track")
public class TrackController {

    private final TrackService trackService;

    @GetMapping("/")
    public List<Track> allTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{id}")
    public Track getTrackById(@PathVariable final Long id) {
        return trackService.getTrack(id);
    }

    @PostMapping("/")
    public Track addTrack(final String name) {
        return trackService.addTrack(name);
    }

    @DeleteMapping("/{id}")
    public void deleteTrack(@PathVariable final Long id) {
        trackService.deleteTrack(id);
    }


}
