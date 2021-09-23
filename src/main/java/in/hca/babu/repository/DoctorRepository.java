package in.hca.babu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> 
{

}
