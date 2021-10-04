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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hca.babu.entity.Patient;
import in.hca.babu.excel.PatientExcelExport;
import in.hca.babu.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService service;
    
	@GetMapping("/show")
	public String viewPage()
	{
		
		return"PatientRegister";
	}
	@PostMapping("/save")
	public String savePage(@ModelAttribute Patient patient,Model model)
	{
		Long id=service.savePatient(patient);
		String message="Patient '"+id+"'is Created";
         model.addAttribute("message",message);		
		return"PatientRegister";
	}
	@GetMapping("/all")
	public String getPage(@ModelAttribute Patient patient,Model model,
			@RequestParam(value="message",required=false)String message)
	{
		List<Patient> list=service.getPatient();
		model.addAttribute("list",list);
		model.addAttribute("message",message);
		model.addAttribute("message",message);
		return"PatientData";
	}
	@GetMapping("/delete")
	public String deletePage(@RequestParam Long id,RedirectAttributes attributes)
	{
	
		service.deletePatient(id);
		//String message="Doctor'"+id+"' is Deleted Successfully";
		attributes.addAttribute("message","Patient Record ("+id+") is Deleted SuccessFully");
		
		return"redirect:all";
	}
	@GetMapping("/edit")
	public String editPage(@RequestParam Long id,Model model)
	{
		Patient patient=service.editPatient(id);
		model.addAttribute("patient",patient);
		return"PatientEdit";
	}
	@PostMapping("/update")
	public String updatePage(@ModelAttribute Patient patient,RedirectAttributes attributes)
	{
		service.updatePatient(patient);
		//String message="Patient'"+patient+"'is successfully";
		attributes.addAttribute("message","Patient("+patient.getId()+")is Updated Successfully");
		return"redirect:all";
	}
	@GetMapping("/excelfile")
	public ModelAndView excelFile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setView(new PatientExcelExport());
		List<Patient> list=service.getPatient();
		mv.addObject("list",list);
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/fnchecked")
	public String ajaxFnValidate(@RequestParam String firstName)
	{
		String message="";
		if(service.isfirstNameExit(firstName))
		{
			message=firstName +" ,is Already Exit Please Enter Enother Name";
		}
		return message;
	}
	
	@ResponseBody
	@GetMapping("/lnchecked")
	public String ajaxLnValidate(@RequestParam String lastName)
	{
		String message="";
		if(service.isLastNameExit(lastName))
		{
			message=lastName +", is Already Exit Please Enter Another Name";
		}
		return message;
	}
}
