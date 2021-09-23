package in.hca.babu.service;

import java.util.List;

import in.hca.babu.entity.Doctor;

public interface DoctorService {
	
	public Integer saveDoctor(Doctor doctor);
	public List<Doctor> getDoctor();
	public void deleteDoctor(Integer id);
	public Doctor editDoctor(Integer id);
	public void updateDoctor(Doctor doctor);
	

}
