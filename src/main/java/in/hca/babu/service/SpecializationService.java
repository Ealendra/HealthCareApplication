package in.hca.babu.service;

import java.util.List;
import java.util.Map;

import in.hca.babu.entity.Specialization;

public interface SpecializationService {
	
	         /*SAVE METOD */
	         public Integer saveSpecialData(Specialization specialization);
	         /*GET ALL DATA METHOD */
	         public List<Specialization> getAllData();
	         /*DELETE METOD*/
	         public  void deleteData( Integer id);
	         /*EDIT METHOD*/
	         public Specialization editData( Integer id);
	        /*UPDATE METHOD*/
             public void updateData(Specialization specialization);
           /* AJAX VALIDATION (Code and Name) METHODS*/
           public boolean isCodeExit(String code);
           
           public boolean isNameExit(String name);
           
           /*MODULE INTEGRATION METHOD*/
           Map<Integer,String> getIDAndName();
          
           
}
