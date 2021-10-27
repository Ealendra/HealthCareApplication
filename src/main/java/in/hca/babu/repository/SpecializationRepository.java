 package in.hca.babu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer>{

	@Query("SELECT COUNT(code) FROM Specialization WHERE code=:code AND id!=:id")
	public Integer codeValidCount(String code);
	
	@Query("SELECT COUNT(name) FROM Specialization WHERE name=:name")
	public Integer nameValidateCount(String name);
	
	// Integration Method B/w Specialization and Doctor..
	@Query("SELECT id,name FROM Specialization")
	public List<Object[]> getIdName();
	
	
}
