package in.hca.babu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hca.babu.entity.Doctor;
import in.hca.babu.exception.DoctorNotFoundException;
import in.hca.babu.repository.DoctorRepository;
import in.hca.babu.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
   
	@Autowired
	private DoctorRepository repo;
	
	@Override
	public Integer saveDoctor(Doctor doctor) {
		
		      doctor=repo.save(doctor);
		
		return doctor.getId();
	}
	@Override
	public List<Doctor> getDoctor() {
		
		        List<Doctor> list=repo.findAll();
		        
		return list;
	}
	@Override
	public void deleteDoctor(Integer id) {
		 repo.deleteById(id);
		
	}
	
	@Override
	public Doctor editDoctor(Integer id) {
		
	return repo.findById(id).orElseThrow(
			    ()-> new DoctorNotFoundException(id+", Not Found"));
	    /*if(dor.isPresent())
	    {
	    	Doctor doctor=dor.get();
	          return doctor;
	    }*/
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateDoctor(Doctor doctor) {
		 
		if(repo.existsById(doctor.getId()))
	
		       repo.save(doctor);	
		else
			throw new DoctorNotFoundException(doctor.getId()+"Not Exit"); 
	}
}
