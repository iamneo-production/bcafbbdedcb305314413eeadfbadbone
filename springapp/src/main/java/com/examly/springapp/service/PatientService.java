package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Patient;
import com.examly.springapp.repository.PatientRepo;



@Service
public class PatientService{

	@Autowired
	private PatientRepo patientRepo;

	public boolean savePatient(Patient patient) {
		return patientRepo.save(patient) != null ? true : false;
	}

	public boolean updatePatient(Patient patient, int patientId) {
			return patientRepo.save(patient) != null ? true : false;
	}

	public boolean deletePatient(int id) {
		if (patientRepo.existsById(id)) {
			patientRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Patient> getAllPatient() {

		List<Patient> list = patientRepo.findAll();
		return list;
	}

	public Patient getPatientById(int id) {

		if (patientRepo.existsById(id)) {
			Patient patient = patientRepo.findById(id).get();
			return patient;
		}

		return null;
	}

}
