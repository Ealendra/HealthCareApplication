package in.hca.babu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> 
{

	//1.Integration Method.
	@Query("SELECT id, firstName, lastName FROM Doctor")
	public List<Object[]> getIdName();
	
	//2.Appoint searching Method.
	@Query("SELECT doc FROM Doctor doc INNER JOIN doc.specialization as spec WHERE spec.id=:id")
	public List<Doctor> findDoctorBySpecId(Integer id);
	
}
