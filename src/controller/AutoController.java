package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.Automobile;
import service.AutoService;

@Controller
public class AutoController {
	@Autowired
	private AutoService autoService;
	
	@RequestMapping(value = "/autos")
	public String listAutos(ModelMap model) throws ClassNotFoundException, SQLException{
		List<Automobile> automobiles=autoService.getAutos();
		model.addAttribute("autos", automobiles);
		return "autos";
	}
	
	@RequestMapping(value = "/arithemetic")
	public void arithemeticExceptionSample() {
		int a=89/0;
	}
	@RequestMapping(value = "/array")
	public void arrayBoundSample() {
		int[] a=new int[3];
		a[5]=56;
	}

}
