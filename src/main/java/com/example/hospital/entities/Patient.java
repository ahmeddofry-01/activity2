package com.example.hospital.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezvous;

}
