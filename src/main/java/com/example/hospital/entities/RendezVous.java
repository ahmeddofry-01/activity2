package com.example.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter
@ToString
@Builder
public class RendezVous {
    @Id
    private String id;
    private Date dateRDV;
    @Enumerated(EnumType.STRING)
    private StatusRdv statusRdv;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medcien medcien;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
