package com.ty.arsapp.dao;

import com.ty.arsapp.dto.Employee;

public interface EmployeeDao {
	Employee saveEmployee(Employee employee);

	Employee validateEmployee(String email, String password);
	
	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee employee, int id);

	boolean deleteEmployee(int id);

}
