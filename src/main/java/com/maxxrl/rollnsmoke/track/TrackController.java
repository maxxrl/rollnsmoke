package com.maxxrl.rollnsmoke.track;

import com.maxxrl.rollnsmoke.smokytracker.SmokyTrackerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/track")
public class TrackController {

    private final TrackService trackService;
    private final SmokyTrackerFacade smokyTrackerFacade;

    @GetMapping("/")
    public List<Track> allTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{id}")
    public Track getTrackById(@PathVariable final Long id) {
        return trackService.getTrack(id);
    }


    @DeleteMapping("/{id}")
    public void deleteTrack(@PathVariable final Long id) {
        trackService.deleteTrack(id);
    }

    @PostMapping("/{id}")
    public Track addSmokyToTrack(@RequestBody final String name, @PathVariable final Long id) {
        return smokyTrackerFacade.addSmokyToTrack(name, id);
    }


}
