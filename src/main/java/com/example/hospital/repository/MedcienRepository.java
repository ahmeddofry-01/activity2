package com.example.hospital.repository;

import com.example.hospital.entities.Medcien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcienRepository extends JpaRepository<Medcien, Long> {
    public Medcien findByName(String name);
}
