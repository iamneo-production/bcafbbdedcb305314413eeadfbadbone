package com.examly.springapp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Patient;
import com.examly.springapp.service.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping
	public ResponseEntity<Boolean> save(@RequestBody Patient patient) {

		boolean s = patientService.savePatient(patient);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.ALREADY_REPORTED);
	}

	@PutMapping("/{patientId}")
	public ResponseEntity<Boolean> update(@RequestBody Patient patient, @PathVariable int patientId) {

		boolean s = patientService.updatePatient(patient, patientId);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{patientId}")
	public ResponseEntity<Boolean> delete(@PathVariable int patientId) {

		boolean s = patientService.deletePatient(patientId);
		if (s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Patient>> getAll() {

		List<Patient> patients = patientService.getAllPatient();
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}

	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> getById(@PathVariable int patientId) {

		Patient patient = patientService.getPatientById(patientId);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

}
