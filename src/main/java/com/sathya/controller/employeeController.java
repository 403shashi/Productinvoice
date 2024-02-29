package com.sathya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class employeeController {
	
	@RequestMapping("/")
	
	public String fullname() {
		return "employeedetails";
	}
	@RequestMapping("/req1")
	public String  details(@RequestParam int eno,@RequestParam String ename, @RequestParam Double esal, ModelMap model  ){
		model.put("eno",eno);
		model.put("ename",ename);
		model.put("esal", esal);
		 double ta =0.0;
		 double da =0.0;
		 double hra =0.0;
		 double pf =0.0;
		 double grossSalary;
		 double netSal;
		 if(esal<3000) {
			 ta=esal*0.07;
			 da=esal*0.09;
			 hra=esal*0.11;
			 pf=esal*0.15;
			 grossSalary=esal+hra+da;
			 netSal=grossSalary-ta-pf; 
		 }
		 else if(esal>=3000 &&(esal<5000))
		 {
			 ta=esal*0.12;
			 da=esal*0.13;
			 hra=esal*0.17;
			 pf=esal*0.22;
			 grossSalary=esal+hra+da;
			 netSal=grossSalary-ta-pf;  
		 }
		 else {
			 ta=esal*0.17;
			 da=esal*0.19;
			 hra=esal*0.21;
			 pf=esal*0.25;
			 grossSalary=esal+hra+da;
			 netSal=grossSalary-ta-pf;  
			 
		 }
		 model.put("ta", ta);
		 model.put("da", da);
		 model.put("hra", hra);
		 model.put("pf", pf);
		 model.put("ta", ta);
		 model.put("grossSalary", grossSalary);
		 model.put("netsal",netSal);
		 
		return "result";
	}
}

