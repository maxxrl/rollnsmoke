package com.maxxrl.rollnsmoke.smoky;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "t_smoky")
public class Smoky {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate rolledDate;
    private int smokeCount;


}
