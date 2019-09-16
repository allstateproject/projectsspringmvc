package com.allstate.training.ffd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private int doj;
	private int dol;
	@ManyToOne(cascade=CascadeType.ALL )
	private Shop shop;
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	private int age;
	private String desgination;
	private long salary;
	@Column(nullable=false)
	private int leaves;
	private int leaveAvailable;
	private String ename;
	private String pass;
	private String manager;
	private String status1;
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
	public int getLeaves() {
		return leaves;
	}
	public void setLeaves(int leaves) {
		this.leaves = leaves;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", doj=" + doj + ", dol=" + dol + ", age=" + age + ", desgination="
				+ desgination + ", salary=" + salary + ", leaves=" + leaves + ", leaveAvailable=" + leaveAvailable
				+ ", ename=" + ename + ", pass=" + pass + ", manager=" + manager + ", status1=" + status1 + "]";
	}
	
	
	
	

}
