package com.maxxrl.rollnsmoke.track;

import com.maxxrl.rollnsmoke.smoky.Smoky;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "smoky_id", nullable = false)
    private Smoky smoky;

    private LocalDate smokeDate;

    @PrePersist
    public void prePersist() {
        smokeDate = LocalDate.now();
    }

}
