package in.hca.babu.service;

import java.util.List;
import java.util.Map;

import in.hca.babu.entity.Doctor;

public interface DoctorService {
  /** Curd Operation Methods*/	
	public Integer saveDoctor(Doctor doctor);
	public List<Doctor> getDoctor();
	public void deleteDoctor(Integer id);
	public Doctor editDoctor(Integer id);
	public void updateDoctor(Doctor doctor);
	
	/**Module Integartion Method*/
 public Map<Integer,String> getIdAndName();
}
