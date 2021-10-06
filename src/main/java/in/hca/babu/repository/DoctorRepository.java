package in.hca.babu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> 
{

	@Query("SELECT id, firstName, lastName FROM Doctor")
	public List<Object[]> getIdName();
	
	
}
