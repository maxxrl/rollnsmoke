package com.maxxrl.rollnsmoke.smokytracker;

import com.maxxrl.rollnsmoke.track.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/smokytracker")
public class SmokyTrackerController {


    private final SmokyTrackerFacade smokyTrackerFacade;


}
