package in.hca.babu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hca.babu.entity.Appointment;
import in.hca.babu.repository.AppointmentRepository;
import in.hca.babu.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository repo;
	
	@Override
	public Integer saveData(Appointment appointment) {
		
	   appointment =repo.save(appointment);
		return appointment.getId();
	}
	@Override
	public List<Appointment> getAllData() {
		List<Appointment> list=repo.findAll();
		return list;
	}
	@Override
	public void deleteData(Integer id) {
		repo.deleteById(id);	
	}
	
	@Override
	public Appointment editData(Integer id) {
		
		
		
		
		Optional<Appointment> app=repo.findById(id);
		
		if(app.isPresent())
		{
			Appointment appointment= app.get();
			return appointment;
		}
	
		return null;
	
	}
	
	@Override
	public void updateData(Appointment appointment) {
		repo.save(appointment);
		
	}
	@Override
	public List<Object[]> bookAppointmentByDocId(Integer id) {
		
		return repo.bookAppointmentByDocId(id);
	}
}
