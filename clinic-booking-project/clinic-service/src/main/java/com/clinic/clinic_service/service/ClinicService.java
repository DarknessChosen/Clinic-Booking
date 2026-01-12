package com.clinic.clinic_service.service;

import com.clinic.clinic_service.entity.Clinic;
import com.clinic.clinic_service.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    private final ClinicRepository repository;

    public ClinicService(ClinicRepository repository) {
        this.repository = repository;
    }

    public Clinic save(Clinic clinic) {
        return repository.save(clinic);
    }

    public List<Clinic> findAll() {
        return repository.findAll();
    }
}
