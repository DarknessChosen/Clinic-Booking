package com.clinic.clinic_service.controller;

import com.clinic.clinic_service.entity.Clinic;
import com.clinic.clinic_service.service.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping
    public Clinic create(@RequestBody Clinic clinic) {
        return clinicService.save(clinic);
    }

    @GetMapping
    public List<Clinic> getAll() {
        return clinicService.findAll();
    }
}
