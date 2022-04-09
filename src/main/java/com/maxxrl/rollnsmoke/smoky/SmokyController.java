package com.maxxrl.rollnsmoke.smoky;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/smoky")
public class SmokyController {

    private final SmokyService smokyService;

    @GetMapping("/")
    public List<Smoky> getSmokies() {
        return smokyService.getSmokies();
    }

    @GetMapping("/{id}")
    public Smoky getSmokyById(@PathVariable final Long id) {
        return smokyService.getSmoky(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSmoky(@PathVariable final Long id) {
        smokyService.deleteSmoky(id);
    }

    @PostMapping("/")
    public Smoky rollSmoky(@RequestBody final String name) {
        return smokyService.rollSmoky(name);
    }

    @PutMapping("/{id}/smoke")
    public Smoky smokeSmoky(@PathVariable final Long id) {
        return smokyService.smokeSmoky(id);
    }
    @PostMapping("/{id}/finish/")
    public Smoky finishSmoky(@PathVariable final Long id) {
        return smokyService.switchSmokyState(id, SmokyState.DEAD);
    }

}
