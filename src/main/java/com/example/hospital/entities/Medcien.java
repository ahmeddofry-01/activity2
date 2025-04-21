package com.example.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity(name = "medciens")
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@Builder
public class Medcien {

//    public Medcien(Long id, String name,String specialite,Collection<RendezVous> rendezvousList) {
//        this.id = id;
//        this.name = name;
//        this.specialite = specialite;
//        this.rendezvousList = rendezvousList;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medcien", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<RendezVous> rendezvousList;
}
