package in.hca.babu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.hca.babu.entity.Appointment;
import in.hca.babu.service.AppointmentService;
import in.hca.babu.service.DoctorService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	/**Over ride the Child(doctor) Service for Module Integration */
	@Autowired
	private DoctorService doctorService;
	
	/** Create One Method For reusability for Module Integration. 
	 * and Over Ride this method at Save method && Edit method*/

	private void dynamicDocNames(Model model)
	{
		model.addAttribute("doctors",doctorService.getIdAndName());
	}
	
	
	@GetMapping("/show")
	public String viewPage(Model model)
	{
		   dynamicDocNames(model);
		
		return"AppointmentRegister";
	}
	
	@PostMapping("/save")
	public String savePage(@ModelAttribute Appointment appointment,Model model)
	{
		        Integer id=service.saveData(appointment);
		        String message=" '"+id+"'st Appoint is Booked...!!! ";
		        model.addAttribute("message",message);
		       // model.addAttribute("appointment",new Appointment()) ;
		     
		return"AppointmentRegister";
	}
	@GetMapping("/all")
	public String getPage(@ModelAttribute Appointment appointment,Model model)
	{
		List<Appointment> list=service.getAllData();
		model.addAttribute("list",list);
		return"AppointmentData";
	}
	
	@GetMapping("/delete")
	public String deletePage(@RequestParam Integer id,Model model)
	{
		service.deleteData(id);
		String message="Appoint ("+id+")th Record is Deleted Successfully";
		model.addAttribute("message",message);
		List<Appointment> list=service.getAllData();
		model.addAttribute("list",list);
		return"AppointmentData";
	}
	@GetMapping("/edit")
	public String editPage(@RequestParam Integer id,Model model)
	{
		Appointment appointment = service.editData(id);
		model.addAttribute("appointment",appointment);
		dynamicDocNames(model);
		return"AppointmentEdit";
	}
	@PostMapping("/update")
	public String updatePage(@ModelAttribute Appointment appointment,Model model)
	{
	      service.updateData(appointment);
	      
	      model.addAttribute("message","("+appointment.getId()+"),Appointment is Updated success fully");
	      
		return"redirect:all";
	}
}
