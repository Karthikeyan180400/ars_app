package com.ty.arsapp.service.impl;

import com.ty.arsapp.dao.impl.EmployeeDaoImp;
import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.service.EmployeeService;

public class EmployeeServiceImp implements EmployeeService {
	EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDaoImp.saveEmployee(employee);
	}

	@Override
	public Employee validateEmployee(String email, String password) {
		return employeeDaoImp.validateEmployee(email, password);
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		return employeeDaoImp.updateEmployee(employee, id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDaoImp.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDaoImp.getEmployeeById(id);
	}

}
