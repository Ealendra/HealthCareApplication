package in.hca.babu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

	@Query("SELECT COUNT(firstName) FROM Patient WHERE firstName=:firstName")
	public Integer firstNameCount(String firstName);
	@Query("SELECT COUNT(lastName) FROM Patient WHERE lastName=:lastName")
	public Integer lastNameCount(String lastName);
}
