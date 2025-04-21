package com.example.hospital.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.Date;

@Entity(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Builder
@Getter
@Setter
@ToString
public class Patient {
//    public Patient(Long id ,String name,Date dateNaissance, boolean malade, Collection<RendezVous> rendezvous) {
//        this.id = id;
//        this.name = name;
//        this.dateNaissance = dateNaissance;
//        this.malade = malade;
//        this.rendezvous = rendezvous;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezvous;

}
