package com.maxxrl.rollnsmoke.smoky;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SmokyService {
    private final SmokyRepository smokyRepository;


    public List<Smoky> getSmokies() {
        return smokyRepository.findAll();
    }

    public Smoky getSmoky(final Long id) {
        return smokyRepository.findById(id).orElseThrow(() -> new SmokyNotFoundException("Could not find smoky with id " + id));
    }

    public Smoky rollSmoky(final String name) {
        Smoky smoky = new Smoky();
        smoky.setRolledDate(LocalDateTime.now());
        smoky.setName(name);
        return smokyRepository.save(smoky);
    }

    public Smoky smokeSmoky(final Long id) {
        Smoky smoky = smokyRepository.findById(id).orElseThrow(() -> new SmokyNotFoundException("Could not find smoky with id " + id));
        if (smoky.getState().equals(SmokyState.ROLLED)) {
            smoky.setState(SmokyState.BURNING);
        }
        smoky.setLastSmoked(LocalDateTime.now());
        return smokyRepository.save(smoky);
    }

    public Smoky switchSmokyState(final Long id, SmokyState state) {
        Smoky smoky = smokyRepository.findById(id).orElseThrow(() -> new SmokyNotFoundException("Could not find smoky with id " + id));
        smoky.setState(state);
        smoky.setLastSmoked(LocalDateTime.now());
        return smokyRepository.save(smoky);
    }

    public void deleteSmoky(final Long id) {
        try {
            smokyRepository.deleteById(id);
        } catch (Exception e) {
            throw new SmokyNotFoundException("Could not find smoky with id " + id);
        }
    }

    public Smoky findByName(final String name) {
        return smokyRepository.findSmokyByName(name).orElseThrow(() -> new SmokyNotFoundException("Could not find smoky with name: " + name));
    }

}
