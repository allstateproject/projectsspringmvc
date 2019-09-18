package com.allstate.training.ffd.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allstate.training.ffd.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);//insert statement
		session.getTransaction().commit();//to commit
		session.close();
		
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(e);//insert statement
		session.getTransaction().commit();//to commit
		session.close();	
		
	}

	@Override
	public void updateDolById(int dol,int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee e1=(Employee)session.get(Employee.class,id);
		e1.setDol(dol);
		session.update(e1);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public void setPasswordById(String pass,int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee e2=(Employee)session.get(Employee.class,id);
		e2.setPass(pass);;
		session.update(e2);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public void setUsername(String username) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee e1 = null;
		e1.setUsername(username);;
		session.update(e1);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public Employee getUsernameById(int id) {
		Session session=sessionFactory.openSession();
		Employee e3=(Employee)session.get(Employee.class, id);
		System.out.println(e3.getUsername());
		session.close();
		return e3;
	}
	
	@Override
	public Employee getLeaveAvailableById(int id) {
		Session session=sessionFactory.openSession();
		Employee e4=(Employee)session.get(Employee.class, id);
		System.out.println(e4.getLeaveAvailable());
		session.close();
		return e4;
	}
	@Override
	public void updateLeavesById(int leaves,int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee e1=(Employee)session.get(Employee.class,id);
		e1.setLeaves(leaves);
		session.update(e1);
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public Employee getEmployeeById(int id) {
		Session session=sessionFactory.openSession();
		Employee e=(Employee)session.get(Employee.class, id);
		System.out.println(e);
		session.close();
		return e;
		
	}
	@Override
	public List<Employee> getAll() {
		Session session=sessionFactory.openSession();
		List<Employee> e=session.createCriteria(Employee.class).list();
		System.out.println(e);
		return e;
		
	}
	@Override
	public List<Employee> getEmployeeByDesignation(String designation) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("designation",designation));
		List<Employee> e=cr.list();
		return e;
		
	}
	
	public Employee login(String username ,String pass)
	{
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		Criterion username1 = Restrictions.eq("username", username);
		Criterion pass1 = Restrictions.eq("pass",pass);
		// To get records matching with AND conditions
		LogicalExpression andExp = Restrictions.and(username1, pass1);
		cr.add( andExp );
		Employee employee=(Employee) cr.uniqueResult();
		return employee;
		
	}
	

	
}
