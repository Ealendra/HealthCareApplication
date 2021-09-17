package in.hca.babu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hca.babu.entity.Specialization;
import in.hca.babu.repository.SpecializationRepository;
import in.hca.babu.service.SpecializationService;
@Service
public class SpecializationServiceImpl implements SpecializationService{
	@Autowired
	private SpecializationRepository repo;
	
	@Override
	public Integer saveSpecialData(Specialization specialization) {
		
		specialization =repo.save(specialization);
		
		return specialization.getId();
	}
	
	@Override
	public List<Specialization> getAllData() {
		 
		List<Specialization> list=repo.findAll();
		return list;
	}
	
	@Override
	public void deleteData(Integer id) {
		
		repo.deleteById(id);
		
	}
	
	@Override
	public Specialization editData(Integer id) {
		
		Optional<Specialization>  val=repo.findById(id);
		
		if(val.isPresent())
		{
			Specialization data = val.get();
			return data;
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateData(Specialization specialization) {
		
		        repo.save(specialization);
	}
	
	@Override
	public boolean isCodeExit(String code) {
		
		         /* Integer count=repo.codeValidCount(code);
		                  boolean exit=count>0 ? true:false;
		                  return exit;*/
		
		
		return repo.codeValidCount(code)>0;
	}
	@Override
	public boolean isNameExit(String name) {
		
		              Integer count=repo.nameValidateCount(name);
		                      boolean exit=count>0 ? true:false;
		                      return exit;
		
		/* return repo.nameValidateCount(name)>0; */
	}

	
	
}
