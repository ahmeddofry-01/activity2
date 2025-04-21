package com.example.hospital;


import com.example.hospital.entities.*;
import com.example.hospital.repository.ConsultationRepository;
import com.example.hospital.repository.MedcienRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.RendezVousRepository;
import com.example.hospital.service.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedcienRepository medcienRepository;
	@Autowired
	private RendezVousRepository rendezVousRepository;
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private HospitalServiceImpl hospitalService;

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of("Najat","Said","Najib")
				.forEach(name -> {
					Patient patient = new Patient();
					patient.setDateNaissance(new Date());
					patient.setName(name);
					patient.setMalade(false);
					hospitalService.savePatient(patient);
				});
		Stream.of("Ahmed","Rachid","Abderrahim")
				.forEach(name -> {
					Medcien medcien = new Medcien();
					medcien.setName(name);
					medcien.setEmail(name+"@gmail.com");
					medcien.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
					medcienRepository.save(medcien);
				});

		//System.out.println(patientRepository.findByName("Hassan"));

		RendezVous rendezVous = new RendezVous();
		rendezVous.setDateRDV(new Date());
		rendezVous.setStatusRdv(StatusRdv.PENDING);
		rendezVous.setPatient(patientRepository.findByName("Najat"));
		rendezVous.setMedcien(medcienRepository.findByName("Ahmed"));
		hospitalService.saveRDV(rendezVous);

		RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
		Consultation consultation = new Consultation();
		consultation.setDateConsultation(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapportConsultation("rapport consultation ...........");
		consultationRepository.save(consultation);
	}
}
