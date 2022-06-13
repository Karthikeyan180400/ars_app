package com.ty.arsapp.service;

import com.ty.arsapp.dto.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	Employee validateEmployee(String email, String password);
	
	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee employee, int id);

	boolean deleteEmployee(int id);

}
