package com.ty.arsapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.arsapp.dao.EmployeeDao;
import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.dto.User;

public class EmployeeDaoImp implements EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public Employee saveEmployee(Employee employee) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Employee validateEmployee(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select e from Employee e where e.email=?1 and e.password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Employee> employees = query.getResultList();
		if (employees.size() > 0) {
			for (Employee employee : employees) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Employee employee2 = entityManager.find(Employee.class, id);
		employee2.setName(employee.getName());
		employee2.setRole(employee.getRole());
		employee2.setEmail(employee.getEmail());
		employee2.setPassword(employee.getPassword());
		employee2.setGender(employee.getGender());
		employee2.setPhone(employee.getPhone());

		entityTransaction.begin();
		entityManager.merge(employee2);
		entityTransaction.commit();
		return employee2;
	}

	@Override
	public boolean deleteEmployee(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

}
