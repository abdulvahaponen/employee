package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
     @Autowired
     EmployeeRepository employeeRepository;
	@Override
	public List<Employee> tumEmployeeAl() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	@Override
	public void ekleEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
		}
	@Override
	public Employee alEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> oplOptional=employeeRepository.findById(id);
		Employee employe=null;
		if (oplOptional.isPresent()) {
			employe=oplOptional.get();
		}else {
			throw new RuntimeException("Çalışan bulunamadı:: "+id);
		}
		return employe;
	}
	@Override
	public void silEmployeeById(long id) {
		// TODO Auto-generated method stub
              this.employeeRepository.deleteById(id);		
	}

}
