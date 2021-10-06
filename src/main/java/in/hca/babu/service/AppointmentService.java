package in.hca.babu.service;

import java.util.List;

import in.hca.babu.entity.Appointment;

public interface AppointmentService {
	
	public Integer saveData(Appointment appointment);
    public List<Appointment> getAllData();
    public void deleteData(Integer id);
    public Appointment editData(Integer id);
    public void updateData(Appointment appointment);
}
