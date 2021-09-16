package in.hca.babu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hca.babu.entity.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer>{

}
