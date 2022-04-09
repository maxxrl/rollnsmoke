package com.maxxrl.rollnsmoke.smokytracker;

import com.maxxrl.rollnsmoke.smoky.Smoky;
import com.maxxrl.rollnsmoke.smoky.SmokyService;
import com.maxxrl.rollnsmoke.track.Track;
import com.maxxrl.rollnsmoke.track.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SmokyTrackerFacade {

    private final SmokyService smokyService;
    private final TrackService trackService;

    public Track addSmokyToTrack(final String name, final Long trackId) {
        Smoky smoky = smokyService.findByName(name);
        return trackService.addTrack(smoky);

    }


}
