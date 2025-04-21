package com.example.hospital.web;

import com.example.hospital.entities.Patient;
import com.example.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private IHospitalService hospitalService;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return hospitalService.getPatients();
    }
}
