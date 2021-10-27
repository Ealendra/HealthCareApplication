package in.hca.babu.service;

import java.util.List;
import java.util.Map;

import in.hca.babu.entity.Doctor;

public interface DoctorService {
  /** Curd Operation Methods*/	
	//1.. Save Data Method.
	public Integer saveDoctor(Doctor doctor);
	//2.. Get All Data Method.
	public List<Doctor> getDoctor();
	//3.Delete Data Method.
	public void deleteDoctor(Integer id);
	//4.Edit Data Method.
	public Doctor editDoctor(Integer id);
	//.Update Data Method.
	public void updateDoctor(Doctor doctor);
	
	/**Module Integration Method*/
 public Map<Integer,String> getIdAndName();
 
 /**Appointment Integration*/
   public List<Doctor> findDoctorBySpecId(Integer id);
  
 
  
} 


