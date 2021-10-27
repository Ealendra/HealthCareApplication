package in.hca.babu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hca.babu.constant.UserRoles;
import in.hca.babu.entity.Doctor;
import in.hca.babu.entity.User;
import in.hca.babu.exception.DoctorNotFoundException;
import in.hca.babu.repository.DoctorRepository;
import in.hca.babu.service.DoctorService;
import in.hca.babu.service.UserService;
import in.hca.babu.util.MyCollectionsUtil;
import in.hca.babu.util.MyMailUtil;
import in.hca.babu.util.UserUtils;

@Service
public class DoctorServiceImpl implements DoctorService{
   
	@Autowired
	private DoctorRepository repo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserUtils util;
	
	@Autowired
	private MyMailUtil mailUtil;
	
	@Override
	public Integer saveDoctor(Doctor doctor) {
		
		    /**  doctor=repo.save(doctor);
		
		return doctor.getId(); */
		
	          
		  Integer id = repo.save(doctor).getId();

		if(id!=null)
		{
			String pwd=util.genPwd();
			User user=new User();
			user.setDisplayName(doctor.getFirstName()+""+doctor.getLastName());
			user.setUserName(doctor.getEmail());
			user.setPassword(util.genPwd());
			user.setRole(UserRoles.DOCTOR.name());
			Integer genId = userService.saveUser(user);
			
			if(genId!=null)
			{
				new Thread(new Runnable()
						{
					public void run()
					{
						String text="Your UserName is"+ doctor.getEmail() +",password is"+ pwd;
						mailUtil.send(doctor.getEmail(),"DoctorAdded",text);
					}
						}
						).start();
				
				
			}	
		}
		return id;
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
	
	@Override
	public Map<Integer, String> getIdAndName() {
		
		       List<Object[]> list = repo.getIdName();
		       
		return MyCollectionsUtil.convertToMapIndex(list);
	}
	
	 
	  @Override
	public List<Doctor> findDoctorBySpecId(Integer id) {
		
		return findDoctorBySpecId(id);
	}
	 
	
	
}
