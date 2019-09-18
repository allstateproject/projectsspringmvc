package com.allstate.training.ffd.daos;

import java.util.List;

import com.allstate.training.ffd.entities.Employee;
import com.allstate.training.ffd.entities.Shop;

public interface EmployeeDao {
public void addEmployee(Employee e);
public void updateEmployee(Employee e);
public void updateDolById(int dol,int id);//update dol and set staus to fired
public void setPasswordById(String pass,int id);
public void setUsername(String userName);
public Employee getUsernameById(int id);
//public List<Employee> getEmployeeByShopId(int sid);
public List<Employee> getEmployeeByShop(Shop s);
public Employee getLeaveAvailableById(int id);
public void updateLeavesById(int leaves,int id);
public Employee getEmployeeById(int id);
public List<Employee> getAll();
public List<Employee> getEmployeeByDesignation(String designation);
public Employee login(String username ,String passsword);
}
