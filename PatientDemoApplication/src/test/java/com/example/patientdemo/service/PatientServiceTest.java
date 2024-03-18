package com.example.patientdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.patientdemo.data.Patient;
import com.example.patientdemo.exception.PatientNotFoundException;
import com.example.patientdemo.repository.PatientRepository;

@SpringBootTest
public class PatientServiceTest {

	@Mock
	private PatientRepository patientRepository;

	@InjectMocks
	private PatientService patientService;

	@Test
	void testGetPatientById() {
		Long patientId = 1L;
		Patient patient = new Patient();
		patient.setId(patientId);
		Mockito.when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

		Patient retrievedPatient = patientService.getPatientById(patientId);

		assertEquals(patient.getId(), retrievedPatient.getId());
	}

	@Test
	void testGetPatientByIdNotFound() {
		Long nonExistentPatientId = 2L;
		Mockito.when(patientRepository.findById(nonExistentPatientId)).thenReturn(Optional.empty());

		assertThrows(PatientNotFoundException.class, () -> patientService.getPatientById(nonExistentPatientId));
	}

}
