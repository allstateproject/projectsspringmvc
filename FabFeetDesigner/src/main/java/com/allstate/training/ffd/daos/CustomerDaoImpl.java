package com.allstate.training.ffd.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.exceptions.BuisnessException;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
  public SessionFactory sessionFactory;
	//@Override
	public void addCustomer(Customer c) throws BuisnessException{
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

	//@Override
	public void updateCustomerPassword(int cid, String newpass) throws BuisnessException{
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Customer c=(Customer)session.get(Customer.class,cid);
		c.setCustomerPassword(newpass);
		session.update(c);
		session.getTransaction().commit();
		session.close();
	}
	

	//@Override
	public void updateCustomerAddress(int cid, String newaddress)throws BuisnessException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Customer c=(Customer)session.get(Customer.class,cid);
		c.setCustomerAddress(newaddress);
		session.update(c);
		session.getTransaction().commit();
		session.close();
	}
		
	

	//@Override
	public void updateCustomerPhone(int cid, String newphone)throws BuisnessException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Customer c=(Customer)session.get(Customer.class,cid);
		c.setCustomerPhoneNumber(newphone);
		session.update(c);
		session.getTransaction().commit();
		session.close();
	}

//	@Override
	public void deleteCustomer(int cid)throws BuisnessException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Customer c=(Customer)session.get(Customer.class,cid);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
	}

	//@Override
	public List<Customer> getAllCustomer()throws BuisnessException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
	//	session.beginTransaction();
		List<Customer> cu=session.createCriteria(Customer.class).list();
		//session.getTransaction().commit();
		session.close();
		return cu;
	}

	//@Override
	public Customer customerLogin(String username, String password) throws BuisnessException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		//session.beginTransaction();
		Criteria cr=session.createCriteria(Customer.class);
		Criterion cusername=Restrictions.eq("customerUserName", username);
		Criterion pass=Restrictions.eq("customerPassword", password);
		LogicalExpression le=Restrictions.and(cusername, pass);
		cr.add(le);
		Customer cu=(Customer)cr.uniqueResult();
		//session.getTransaction().commit();
		session.close();
		return cu;
		
	}

}
