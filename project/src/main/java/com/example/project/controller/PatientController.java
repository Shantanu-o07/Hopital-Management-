package com.example.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Patient;
import com.example.project.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1/")
public class PatientController {
	
	
	@Autowired
	private PatientRepository patientRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exist"));
		return ResponseEntity.ok(patient);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, Patient patientDetails){
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exist"));
		
		patient.setPatientId(patientDetails.getPatientId());
		patient.setPatientName(patientDetails.getPatientName());
		patient.setAge(patientDetails.getAge());
		patient.setDrName(patientDetails.getDrName());
		patient.setInsuranceCompany(patientDetails.getInsuranceCompany());
		
		Patient updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
		
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable Long id){
		
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exist"));
		
		patientRepository.delete(patient);
		Map<String,Boolean> response =new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		}
	
	
}
