package com.allstate.training.ffd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstate.training.ffd.daos.EmployeeDao;
import com.allstate.training.ffd.daos.EmployeeDaoImpl;
import com.allstate.training.ffd.entities.Employee;
import com.allstate.training.ffd.entities.Shop;
import com.allstate.training.ffd.exceptions.BusinessException;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public void addEmployee(Employee e) throws BusinessException {
		if(e.getAge()>21)
			employeeDao.addEmployee(e);
		else 
			throw new BusinessException("EMployee age is very less so cannot be added");
		
	}

	@Override
	public void update(Employee e) throws BusinessException {
		if(e.getEmpId()!=0)
		employeeDao.updateEmployee(e);
		else
			throw new BusinessException("Employee does not exist");
	}

	@Override
	public void updateDolById(int dol, int id) {
		
	employeeDao.updateDolById(dol, id);


			
	}

	@Override
	public void setPasswordById(String pass, int id) throws BusinessException {
		if(pass.matches("[a-zA-Z]{6,}"))
		employeeDao.setPasswordById(pass, id);
		else
			throw new BusinessException("enter password with only alphabets and not less than 4");
		
	}

	@Override
	public void setUsername(String userName) throws BusinessException {
		if(userName.matches("[a-zA-Z]{6,}"))
		employeeDao.setUsername(userName);
		else 
			throw new BusinessException("enter username with only alphabets and not less than 4");
	}

	@Override
	public Employee getLeaveAvailableById(int id) {
		
		Employee e= employeeDao.getLeaveAvailableById(id);
		return e;
	}

	@Override
	public void updateLeavesById(int leaves, int id) throws BusinessException {
		if(leaves<10)
		employeeDao.updateLeavesById(leaves, id);
		else
			throw new BusinessException("Leave duration too large");
	}

	@Override
	public Employee getEmployeeById(int id) throws BusinessException {
		if(id>0)
		{
			Employee e=employeeDao.getEmployeeById(id);
			return e;
		}
		else 
			throw new BusinessException("Employee Id does not exist");
	}

	@Override
	public List<Employee> getAll() throws BusinessException {
		List<Employee> e1=employeeDao.getAll();
		if(!e1.isEmpty())
		{
			return e1;
		}
		else
			throw new BusinessException("no employees available");

	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation) throws BusinessException {
		List<Employee> e2=employeeDao.getEmployeeByDesignation(designation);
		if(!e2.isEmpty())
		{
			return e2;
		}
		else
			throw new BusinessException("no employess for this designation");
	}

	@Override
	public Employee getUsernameById(int id) throws BusinessException {
		Employee e4=new Employee();
		e4=employeeDao.getEmployeeById(id);
		if(e4!=null)
		{
			return e4;
		}
		else
			throw new BusinessException("no username by this EmployeeId");
	}
	public List<Employee> getEmployeeByShop(Shop s) {
		List<Employee> es;
		es=employeeDao.getEmployeeByShop(s);
		
		return es;
	}
	@Override
	public Employee login(String username, String pass) throws BusinessException {
		Employee e5=employeeDao.login(username, pass);
		if(e5!=null)
		{
			return e5;
		}
		else
		{
	
		throw new BusinessException("Login credential invalid");
		}
}

	
}
