package com.clinic.clinic_service.repository;

import com.clinic.clinic_service.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
