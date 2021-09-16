package in.hca.babu.service;

import java.util.List;

import in.hca.babu.entity.Specialization;

public interface SpecializationService {
	
	Integer saveSpecialData(Specialization specialization);
	
	          List<Specialization> getAllData();
	           void deleteData( Integer id);
	             Specialization editData( Integer id);
            void updateData(Specialization specialization);
}
