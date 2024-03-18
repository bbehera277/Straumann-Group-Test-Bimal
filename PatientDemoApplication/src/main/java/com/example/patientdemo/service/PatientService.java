package com.example.patientdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.patientdemo.data.Patient;
import com.example.patientdemo.exception.PatientNotFoundException;
import com.example.patientdemo.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Cacheable("patients")
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	/* @Cacheable(value = "patients", key = "#id") */
	public Patient getPatientById(Long id) {
		/* return patientRepository.findById(id).orElse(null); */
		return patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient Not found with Id:" + id));
	}

	@CacheEvict(value = "patients", allEntries = true)
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	@CacheEvict(value = "patients", allEntries = true)
    public Patient updatePatient(Long id, Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient Not found with Id: " + id);
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

	@CacheEvict(value = "patients", allEntries = true)
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}
