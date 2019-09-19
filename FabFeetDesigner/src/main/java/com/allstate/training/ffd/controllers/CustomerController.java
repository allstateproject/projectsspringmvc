package com.allstate.training.ffd.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.exceptions.BuisnessException;
import com.allstate.training.ffd.services.CustomerService;
import com.allstate.training.ffd.services.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
CustomerService customerService;
	@RequestMapping("/login")
	public String getloginPage() {
		return "login";
	}
	
	@RequestMapping("/signup")
	public String getsignupPage()
	{
		return "customersignup";
	}
	
	@RequestMapping("/customersignup")
	public ModelAndView getSignup(@RequestParam ("customerName")String name,@RequestParam("customerUserName")String username,@RequestParam("customerPassword")String password,@RequestParam("customerPhoneNumber")String phoneno,@RequestParam("customerAddress")String address)
	
	{
		ModelAndView mv=new ModelAndView();
		Customer c=new Customer();
		c.setCustomerName(name);
		c.setCustomerUserName(username);
		c.setCustomerPassword(password);
		c.setCustomerPhoneNumber(phoneno);
		c.setCustomerAddress(address);
		try
		{customerService.addCustomer(c);
		String s="Sign up Completed. You can login now.";
		 mv.addObject("message",s);
		  mv.setViewName("index");
		}
		catch(BuisnessException e)
		{
			mv.addObject("errorMessage",e.getMessage());
			mv.setViewName("customersignup");
		}
		
		return mv;
	}
	@RequestMapping("/logincustomer")
	public ModelAndView  loginCustomer(@RequestParam("username")String username, @RequestParam("password")String password,HttpSession Session)
	{
		ModelAndView mv=new ModelAndView();
		try {
			
		Customer c=customerService.customerLogin(username, password);
			mv.addObject("customer",c);
			Session.setAttribute("sname", c.getCustomerName());
			/*mv.addObject("Customerid",c.getCustomerId());
			mv.addObject("Customername",c.getCustomerName());
			mv.addObject("Customerphone",c.getCustomerPhoneNumber());
			mv.addObject("Customeraddress",c.getCustomerAddress());*/
			mv.setViewName("customerpage");
		} catch (BuisnessException e) {
			// TODO Auto-generated catch block
		   mv.addObject("loginerror",e.getMessage());
		   mv.setViewName("login");
		}
		
		return mv;
	}
}

