package com.clinic.appointment_service.service;

import com.clinic.appointment_service.entity.Appointment;
import com.clinic.appointment_service.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }
}

