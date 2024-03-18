package com.example.patientdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patientdemo.data.Patient;
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
