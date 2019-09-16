package com.allstate.training.ffd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int empId;
	private int doj;
	private int dol;
	@ManyToOne(fetch=FetchType.EAGER , cascade=CascadeType.ALL )
	private Shop shop;
	private int age;
	private String desgination;
	private long salary;
	private int leave;
	private int leaveAvailable;
	private String ename;
	private String password;
	private String manager;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getDoj() {
		return doj;
	}
	public void setDoj(int doj) {
		this.doj = doj;
	}
	public int getDol() {
		return dol;
	}
	public void setDol(int dol) {
		this.dol = dol;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesgination() {
		return desgination;
	}
	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getLeave() {
		return leave;
	}
	public void setLeave(int leave) {
		this.leave = leave;
	}
	public int getLeaveAvailable() {
		return leaveAvailable;
	}
	public void setLeaveAvailable(int leaveAvailable) {
		this.leaveAvailable = leaveAvailable;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
	
	

}
