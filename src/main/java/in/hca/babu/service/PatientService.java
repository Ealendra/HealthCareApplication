package in.hca.babu.service;

import java.util.List;

import in.hca.babu.entity.Patient;

public interface PatientService {
	
	public Long savePatient(Patient patient);
	public List<Patient> getPatient();
	public void deletePatient(Long id);
	public Patient editPatient(Long id);
	public void updatePatient(Patient patient);
	
	public boolean isfirstNameExit(String firstName);
	public boolean isLastNameExit(String lastName);

}
