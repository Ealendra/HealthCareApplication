package in.hca.babu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.hca.babu.entity.Appointment;
import in.hca.babu.entity.Doctor;
import in.hca.babu.excel.MyAppointmentExcel;
import in.hca.babu.service.AppointmentService;
import in.hca.babu.service.DoctorService;
import in.hca.babu.service.SpecializationService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	/**Over ride the Child(doctor) Service for Module Integration */
	@Autowired
	private DoctorService doctorService;
	
	//2.Over Ride the Specialization Service.
	@Autowired
	private SpecializationService specialService;
	
	/** Create One Method For reusability for Module Integration. 
	 * and Over Ride this method at Register method && Edit method*/

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
	
	/**Excel Method*/
	@GetMapping("/excel")
	public ModelAndView appExcel()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new MyAppointmentExcel());
		List<Appointment> list=service.getAllData();
		m.addObject("list",list);
		return m;
	}
	
	//..View AppointMent Page..
	        @GetMapping("/view")
	        public String viewDoctors(@RequestParam(required=false,defaultValue="0")Integer id,Model model)
	        {
	        Map<Integer,String> map = specialService.getIDAndName();
	        model.addAttribute("map",map);
	        List<Doctor> list=null;
	        String message=null;
	        if(id<=0)
	        {
	                  list=doctorService.getDoctor();
	                  message="All Doctors";
	        }
	        else
	        {
	        	list=doctorService.findDoctorBySpecId(id);
	        	message="Result :"+specialService.editData(id)+"Doctors";
	        	
	        }
	        model.addAttribute("list",list);
	        model.addAttribute("message", message);
	        	return"AppointmentSearch";
	        }
	        @GetMapping("/viewslots")
	        public String bookAppointment(@RequestParam Integer id,Model model)
	        {
	        List<Object[]> list = service.bookAppointmentByDocId(id);
	        model.addAttribute("list", list);
	          String message="Result :"+doctorService.editDoctor(id).getFirstName();
	        	model.addAttribute("message", message);
	        	return"AppointSlots";
	        }
}
