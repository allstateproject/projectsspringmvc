package com.allstate.training.ffd.services;

import java.util.List;

import com.allstate.training.ffd.entities.Employee;
import com.allstate.training.ffd.exceptions.BusinessException;

public interface EmployeeService {
	public void addEmployee(Employee e) throws BusinessException;
	public void update(Employee e) throws BusinessException;
	public void updateDolById(int dol,int id);//update dol and set staus to fired
	public void setPasswordById(String pass,int id) throws BusinessException;
	public void setUsername(String userName) throws BusinessException;
	public Employee getUsernameById(int id) throws BusinessException;

	public Employee getLeaveAvailableById(int id);
	public void updateLeavesById(int leaves,int id) throws BusinessException;
	public Employee getEmployeeById(int id) throws BusinessException;
	public List<Employee> getAll() throws BusinessException;
	public List<Employee> getEmployeeByDesignation(String designation) throws BusinessException;
	public Employee login(String username ,String pass) throws BusinessException;
}
