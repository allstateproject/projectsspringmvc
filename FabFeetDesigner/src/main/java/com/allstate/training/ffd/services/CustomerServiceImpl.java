package com.allstate.training.ffd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstate.training.ffd.daos.CustomerDao;
import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.exceptions.BuisnessException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
  private CustomerDao customerDao;
//	@Override
	public void addCustomer(Customer c) throws BuisnessException{
		// TODO Auto-generated method stub
		if(c.getCustomerUserName().matches("[A-Za-z]{3,}")&& c.getCustomerPhoneNumber().matches("[0-9]{10}")) {
		customerDao.addCustomer(c);
		}else {
			throw new BuisnessException("Username accepts only letters and size min 3");
		}
	}

	//@Override
	public void updateCustomerPassword(int cid, String newpass) throws BuisnessException{
		// TODO Auto-generated method stub
		customerDao.updateCustomerPassword(cid, newpass);
	}

	//@Override
	public void updateCustomerAddress(int cid, String newaddress) throws BuisnessException {
		// TODO Auto-generated method stub
		customerDao.updateCustomerAddress(cid, newaddress);
	}

	//@Override
	public void updateCustomerPhone(int cid, String newphone) throws BuisnessException {
		// TODO Auto-generated method stub
		if(newphone.matches("[0-9]{10}"))
		customerDao.updateCustomerPhone(cid, newphone);
		else
			throw new BuisnessException("enter correct phone numbers");
	}

	//@Override
	public void deleteCustomer(int cid) throws BuisnessException {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(cid);
	}

//	@Override
	public List<Customer> getAllCustomer()throws BuisnessException{
		// TODO Auto-generated method stub
		List<Customer> cu=customerDao.getAllCustomer();
		if(cu.isEmpty())
			throw new BuisnessException("list is empty");
		else
		return cu;
	}

	//@Override
	public Customer customerLogin(String username, String password) throws BuisnessException {
		// TODO Auto-generated method stub
		Customer cu= customerDao.customerLogin(username, password);
		if(cu==null)
			throw new BuisnessException("incorrect username or password");
		else
			return cu;
	}

}
