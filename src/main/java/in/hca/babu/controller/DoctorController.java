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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hca.babu.entity.Doctor;
import in.hca.babu.excel.DoctorExcelExport;
import in.hca.babu.exception.DoctorNotFoundException;
import in.hca.babu.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService service;
	
	@GetMapping("/show")
	public String viewPage(@RequestParam(value="message",required=false)String message,Model model)
	{
		model.addAttribute("message",message);
		return"DoctorRegister";
	}
	
	@PostMapping("/save")
	public String SaveData(@ModelAttribute Doctor doctor,RedirectAttributes attributes)
	{
		Integer id=service.saveDoctor(doctor);
		//String message="Doctor '"+id+"'is Created";
		attributes.addAttribute("message","Doctor("+id+")is Created");
		return"redirect:show";
	}
  @GetMapping("/all")
	public String getAllData(
			@RequestParam(value="message",required=false)
	      String message,Model model)
	{
	     List<Doctor> list= service.getDoctor();
	     model.addAttribute("list",list);
	     model.addAttribute("message",message);
		return"DoctorData";
	}
  @GetMapping("/delete")
  public String deleteData(@RequestParam("id") Integer id,RedirectAttributes attributes)
  {
	  String message=null;
	  try
	  {
		  service.deleteDoctor(id);
		  message="Doctor Removied";
	  }catch(DoctorNotFoundException e){
		  e.printStackTrace();
		  e.getMessage();
		  
	  }
	  //String message="Doctor Record '"+id+"'is Deleted";
	  attributes.addAttribute("message","Doctor Record ("+id+")is Deleted");
	 // List<Doctor> list= service.getDoctor();
	 // model.addAttribute("list",list);
	  return"redirect:all";
  }
  @GetMapping("/edit")
  public String editData(@RequestParam("id")Integer id,Model model,RedirectAttributes attributes)
  {
	  String page=null;
	  try
	  {
		  Doctor doctor=service.editDoctor(id);
		  model.addAttribute("doctor",doctor);
		  return"DoctorEdit";
	  }catch(DoctorNotFoundException e) {
		  e.printStackTrace();
		  attributes.addAttribute("message",e.getMessage());
		  page="redirect:all"; 
	  }
	  return page;
	  
  }
  @PostMapping("/update")
  public String updateData(@ModelAttribute Doctor doctor,RedirectAttributes attributes)
  {
	  service.updateDoctor(doctor);
	  attributes.addAttribute("message",doctor.getId()+",updated");
	  return"redirect:all";
  }
  @GetMapping("/excel")
  public ModelAndView excelExport()
  {
	  ModelAndView m=new ModelAndView();
	  m.setView(new DoctorExcelExport());
	  List<Doctor> list= service.getDoctor();
	  m.addObject("list",list);
	  return m;
  }
}
