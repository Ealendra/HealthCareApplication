package in.hca.babu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hca.babu.entity.Patient;
import in.hca.babu.repository.PatientRepository;
import in.hca.babu.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository repo;
	
	@Override
	public Long savePatient(Patient patient) {
		      
		           patient=repo.save(patient);
		return patient.getId();
	}
	@Override
	public List<Patient> getPatient() {
		         List<Patient> list=repo.findAll();
		return list;
	}
	
	@Override
	public void deletePatient(Long id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public Patient editPatient(Long id) {
		
		Optional<Patient> opt=repo.findById(id);
		  if(opt.isPresent())
		  {
			  Patient patient=opt.get();
			  return patient;
		  }
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updatePatient(Patient patient) {
		
		repo.save(patient);
		
	}
	
	@Override
	public boolean isfirstNameExit(String firstName) {
		
		           /*Integer count=repo.firstNameCount(firstName);
		                  boolean b=count>0 ? true:false;
		return b;*/
		
		return repo.firstNameCount(firstName)>0;
	}
	@Override
	public boolean isLastNameExit(String lastName) {
		
    Integer count=repo.lastNameCount(lastName);
	        boolean exit= count>0 ? true:false;	              
		
		return exit;
		/*return repo.lastNameCount(lastName)>0;*/
	}

}
