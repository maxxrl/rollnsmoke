package com.maxxrl.rollnsmoke.smoky;

import com.maxxrl.rollnsmoke.track.Track;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "t_smoky")
public class Smoky {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate rolledDate;

    @OneToMany(mappedBy = "smoky")
    private List<Track> tracks;

}
