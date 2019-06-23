package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Emp;
import beans.SearchEmp;
import service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@InitBinder
	public void myInitDateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy#MM#dd");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/emps")
	public String aa(ModelMap model){
		List<Emp> emps=empService.getEmps();
		model.addAttribute("e", emps);
		return "home";
	}
	@RequestMapping(value = "/register")
	public String registerEmp(ModelMap model) {
		model.addAttribute("jio",new Emp());
		return "registerEmp";
	}
	@RequestMapping(value = "/save")
	public String save(@Valid @ModelAttribute("jio") Emp emp,BindingResult result) {
		if(result.hasErrors()) {
			return "registerEmp";
		}
		empService.save(emp);
		return "redirect:emps";
	}
	@RequestMapping("/update")
	public String updateEmp(@RequestParam("empId") int id,ModelMap model) {
		Emp emp=empService.getEmpById(id);
		model.addAttribute("jio",emp);
		return "updateEmp";
	}
	@RequestMapping(value = "/updateEmp")
	public String updateEmp(@ModelAttribute("jio") Emp emp) {
		empService.updateEmp(emp);
		return "redirect:emps";
	}
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") int empId) {
		empService.empDelete(empId);
		return "redirect:emps";
	}
	@RequestMapping(value = "/search")
	public String search(ModelMap model) {
		model.addAttribute("jack", new SearchEmp());
		return "searchEmp";
	}
	@RequestMapping(value = "/searchById")
	public String searchById(@ModelAttribute("jack") SearchEmp searchEmp,ModelMap model) {
		Emp emp=empService.searchEmp(searchEmp.getEmpId());
		model.addAttribute("fiat",emp);
		return "searchEmp";
	}
}
