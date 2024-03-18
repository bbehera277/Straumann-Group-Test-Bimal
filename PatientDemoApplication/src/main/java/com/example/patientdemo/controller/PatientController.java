package com.example.patientdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientdemo.data.Patient;
import com.example.patientdemo.service.PatientService;

@RestController
@RequestMapping("/patient-resources")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@PostMapping("/savePatient")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@GetMapping("/getPatientById/{id}")
	public Patient getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}

	@PutMapping("/updatePatient/{id}")
	public Patient updatePatientResource(@PathVariable Long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}
	
	@DeleteMapping("/deletePatient/{id}")
    public void deletePatientResource(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}