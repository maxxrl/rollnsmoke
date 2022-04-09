package com.maxxrl.rollnsmoke.smoky;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxxrl.rollnsmoke.track.Track;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "t_smoky")
public class Smoky {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime rolledDate;
    private SmokyState state;
    private LocalDateTime lastSmoked;

    @JsonIgnore
    @OneToMany(mappedBy = "smoky")
    private List<Track> tracks;

    @PrePersist
    public void prePersist(){
        state = SmokyState.ROLLED;
    }

}
