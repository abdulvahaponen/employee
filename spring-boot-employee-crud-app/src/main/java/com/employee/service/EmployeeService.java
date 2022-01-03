package com.employee.service;

import java.util.List;
import com.employee.model.Employee;

public interface EmployeeService {
 List<Employee> tumEmployeeAl();
 void ekleEmployee(Employee employee);
 Employee alEmployeeById(long id);
 void silEmployeeById(long id);
}
