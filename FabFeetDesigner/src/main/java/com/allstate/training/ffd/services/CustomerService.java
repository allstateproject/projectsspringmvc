package com.allstate.training.ffd.services;

public interface CustomerService {
	public void addCustomer(Customer c) throws BuisnessException;
	public void updateCustomerPassword(int cid,  String newpass)throws BuisnessException;
	public void updateCustomerAddress(int cid,String newaddress) throws BuisnessException;
	public void updateCustomerPhone(int cid,String newphone) throws BuisnessException ;
	public void deleteCustomer(int cid)throws BuisnessException;
	public List<Customer> getAllCustomer() throws BuisnessException;
	public Customer customerLogin(String username,String password) throws BuisnessException;
}
