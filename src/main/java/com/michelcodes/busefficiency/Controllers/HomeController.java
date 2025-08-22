package com.michelcodes.busefficiency.Controllers;



import java.util.ArrayList;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.michelcodes.busefficiency.Services.RecordService;
import jakarta.validation.constraints.Pattern;


@Controller
public class HomeController {
	
	
	private RecordService rs;
	
	public HomeController( RecordService r) {
		this.rs = r;
		
	}
	@GetMapping ("/")
	public String index(Model model) {
		
		ArrayList<String> arr = rs.getRoutes();
		
		model.addAttribute("routes", arr);
	
		return "index";
		
	}
	
	@GetMapping ("/about")
	public String about(Model model) {	
		return "about";
		
	}
	

	@GetMapping("/routes")
	public String returnBusView(Model model, @RequestParam(defaultValue = "World") @Pattern(regexp = "[0-9A-Z ]+") String busName) {
	
		ArrayList<String> arr = rs.getRoutes();

		if (arr.contains(busName)) {
			
			Map<String, String> records = rs.getLast7Days(busName);
			String [] a = busName.split(" ");
			String fullName="";
			
			String totalScore = rs.getTotalScore(records.values());
			
			for (int i = 1; i < a.length; i++) {
				fullName+= a[i] + " ";
			}
		
			model.addAttribute("totals", totalScore);
			model.addAttribute("stops", records);
			model.addAttribute("name",a[0]);
			model.addAttribute("name2", fullName);
			
			return "/routes";
		} else {
			return "/error";
		}
		
	}
	


}
