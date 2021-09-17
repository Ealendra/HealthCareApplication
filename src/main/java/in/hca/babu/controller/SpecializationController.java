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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.hca.babu.entity.Specialization;
import in.hca.babu.service.SpecializationService;

@Controller
@RequestMapping("/special")
public class SpecializationController {
	
	@Autowired
	private SpecializationService service;
	
	@GetMapping("/show")
	public String viewPage()
	{
		return"SpecializationForm";
	}
	@PostMapping("/save")
	public String saveData(@ModelAttribute Specialization specialization,Model model)
	{
		Integer id=service.saveSpecialData(specialization);
		String message="Specialization Form Data'"+id+"'is Created";
		model.addAttribute("message",message);
		return"SpecializationForm";
	}
	@GetMapping("/all")
	public String getData(Model model,@RequestParam(value="message",required=false)String message)
	{   
		            List<Specialization> list= service.getAllData();
		            model.addAttribute("list",list);
		            model.addAttribute("message",message);
		           return"SpecializationFormData";
	}
	@GetMapping("/delete")
	public String deleteData(@RequestParam Integer id,RedirectAttributes attributes)
	{
		                      
		service.deleteData(id);
		attributes.addAttribute("message","Record ("+id+") is removed");
	
       return"redirect:all";
		
	}
	@GetMapping("/edit")
	public String editForm(@RequestParam Integer id,Model model)
	{
		Specialization data= service.editData(id);
		model.addAttribute("data",data);
		return"SpecializationEditForm";
	}
	@PostMapping("/update")
	public String updateData(@ModelAttribute Specialization specialization,Model model)
	{
		     service.updateData(specialization);
		     model.addAttribute(specialization);
		return"redirect:all";
	}
	
	@ResponseBody
	@GetMapping("/codecheck")
	public String codeValidate(@RequestParam String code)
	{
		String message="";
		if(service.isCodeExit(code))
		{
			message = code+",*is Already Exit Please Enter Another Name";
		}
		return message;
	}
	
	@ResponseBody
	@GetMapping("/namecheck")
	public String NameValidate(@RequestParam String name)
	{
		String message="";
		if(service.isNameExit(name))
		{
			message= name + ",is Already Exit Please Enter Another Name";
		}
		   return message;
	}

}
