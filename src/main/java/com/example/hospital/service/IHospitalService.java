package com.example.hospital.service;

import com.example.hospital.entities.Consultation;
import com.example.hospital.entities.Medcien;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.RendezVous;

import java.util.List;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    public Medcien saveMedcien(Medcien medcien);
    public RendezVous saveRDV(RendezVous rendezVous);
    public Consultation saveConsultation(Consultation consultation);
    public List<Patient> getPatients();
}
