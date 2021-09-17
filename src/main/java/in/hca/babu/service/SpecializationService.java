package in.hca.babu.service;

import java.util.List;

import in.hca.babu.entity.Specialization;

public interface SpecializationService {
	
	public Integer saveSpecialData(Specialization specialization);
	
	       public List<Specialization> getAllData();
	          public  void deleteData( Integer id);
	             public Specialization editData( Integer id);
           public void updateData(Specialization specialization);
           /* AJAX VALIDATION METHOD*/
           public boolean isCodeExit(String code);
           
           public boolean isNameExit(String name);
           
}
