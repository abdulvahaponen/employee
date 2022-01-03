package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
   @Autowired
   EmployeeService employeeService;
   @GetMapping("/")
   public String anaSayfa(Model model) {
	   model.addAttribute("listEmployees",employeeService.tumEmployeeAl());
	   return "index";
   }
   @GetMapping("/showNewEmployeeForm")
   public  String yeniEmployeeFormGoster(Model model) {
	   Employee employee=new Employee();
	   model.addAttribute("employee",employee);
	   return "new_employee";
	   }
   @PostMapping("/saveEmployee")
   public String ekleEmployee(@ModelAttribute("employee")Employee employee) {
	   employeeService.ekleEmployee(employee);
    return "redirect:/";
    		}
   @GetMapping("/showFormForUpdate/{id}")
   public String yeniFormGosterGuncellemeIcin(@PathVariable(value = "id")Long id,Model model) {
	   Employee employee=employeeService.alEmployeeById(id);
	   model.addAttribute("employee",employee);
	   return "update_employee";
   }
   @GetMapping("/deleteEmployee/{id}")
   public String deleteEmployee(@PathVariable(value = "id") long id){
	   this.employeeService.silEmployeeById(id);
	   return "redirect:/";
   }
   
}
