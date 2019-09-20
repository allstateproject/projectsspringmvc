package com.allstate.training.ffd.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.entities.Employee;
import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.entities.Product;
import com.allstate.training.ffd.exceptions.BuisnessException;
import com.allstate.training.ffd.services.CustomerService;
import com.allstate.training.ffd.services.EmployeeService;
import com.allstate.training.ffd.services.OrderService;
import com.allstate.training.ffd.services.ProductService;

@Controller
public class ManagerController {
	@Autowired
	OrderService orderService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ProductService productService;
	@Autowired
	CustomerService customerService;
	@RequestMapping("/LoginManager")
	public String getLogin() {
		return "login";
	}
	
	
	@RequestMapping(value="/loginmanager",method=RequestMethod.POST)
	public ModelAndView getLogin(@RequestParam("username")String uname,@RequestParam("password")String pass, HttpSession session) throws BuisnessException
	{
		ModelAndView mv=new ModelAndView();
		Employee e=employeeService.login(uname,pass);
		if(e!=null)
		{
			session.setAttribute("sname", e.getUsername());
			mv.addObject("uname",uname);
			mv.setViewName("managerView");//redirects to this page when login successful;
		}
		else
		{
			mv.addObject("message","username or password invalid");
			mv.setViewName("index.jsp");//redirect to this page when login failed
		}
		return mv;
	}
	
	@RequestMapping("/RegisterNewProduct")
	public String getRegister(Model model) {
		model.addAttribute("product",new Product());
		return "registerproductjsp";
	}
	
	/*there will be a button called register ,on clicking it it will redirect to register page with all the details 
	 * then submit it which will come to this method    */
	//done
	@RequestMapping(value="/RegisterProduct",method=RequestMethod.POST)
	public ModelAndView getMethod(@ModelAttribute Product product) throws BuisnessException
	{
		ModelAndView mv=new ModelAndView();
		productService.addProduct(product);
		mv.addObject("message","product registered");
		mv.setViewName("managerView");//go to this jsp once product is registered
		return mv;
	}
	//done
	@RequestMapping(value="/StockView")
	public ModelAndView getData() 
	{
		ModelAndView mv=new ModelAndView();
		List<Product> products=null;
		try{
			products=productService.getProducts();
		mv.addObject("listproducts", products);
		mv.setViewName("stock");//display product list on this page
		}
		catch(Exception e)
		{
			mv.addObject("message","No products Available");
			mv.setViewName("stock");
		}
		return mv;
		
	}
	@RequestMapping("/NewPair")
	public String getPair() {
		return "newpair";
	}
	//done
	@RequestMapping(value="/RequestNewPair",method=RequestMethod.POST)
	public ModelAndView getPair(@RequestParam("size")int size,@RequestParam("designnum")int designnum) throws BuisnessException
	{
		ModelAndView mv=new ModelAndView();
		Product pr=null;
		Product prequest=null;
		try		{
			pr=productService.getProductBySizeAndDesign(size, designnum);
			prequest=productService.getProductById(pr.getProductId());
			mv.addObject("product", prequest);	
			mv.setViewName("displaypair");
		}
		catch(Exception e)
		{
			mv.addObject("product","pair not available");
			mv.setViewName("displaypair");
		}
		return mv;
		
	}
	//done
	@RequestMapping(value="/EmployeeView")
	public ModelAndView getEmployeeView()
	{
		ModelAndView mv=new ModelAndView();
		List<Employee> emp;
		try {
			 emp=employeeService.getAll();
		mv.addObject("listemployee",emp);
		mv.setViewName("employee");
		}catch(RuntimeException | BuisnessException e)
		{
			mv.addObject("listemployee","No employees Available");
			mv.setViewName("employee");
		}
		return mv;
	}
	@RequestMapping("/CutomerProfile")
	public String getProf() {
		return "customerprofile";
	}
	
	//done
	@RequestMapping(value="/CreateCutomerProfile" ,method=RequestMethod.POST)
	public ModelAndView createCustomerProfile(@RequestParam("customerUserName") String username,@RequestParam("customerName") String name,@RequestParam("customerPassword") String pass ,@RequestParam("customerPhoneNumber") String phoneNumber ) throws BuisnessException
	
	{
		ModelAndView mv=new ModelAndView();
		//customerService.addCustomer();
		mv.setViewName("managerView");//redirect to this page when customer added
		return mv;
	}
	@RequestMapping("/NewOrderForWalkin")
	public String getOrderBill() {
		return "neworderforwalkin";
	}
	
	//done
	@RequestMapping(value="/BillingForWalkin",method=RequestMethod.POST)
	public ModelAndView billing(@RequestParam("orderDate") String date,@RequestParam("paymentType") String type,@RequestParam("totalqty") int qty,@RequestParam("totalcost")int cost) throws BuisnessException
	{
		ModelAndView mv=new ModelAndView();
		Order ot=new Order();
		ot.setOrderDate(date);
		ot.setPaymentType(type);
		ot.setTotalqty(qty);
		ot.setTotalcost(cost);
		orderService.newOrder(ot);
		mv.addObject("billamount",ot);
		mv.setViewName("bill");
		
		
		return mv;
		
	}
	@RequestMapping(value="/Logout")
	public String logoutmanager(HttpSession session)
	{
		
		session.removeAttribute("sname");
		session.invalidate();
		return "index";
				
	}
}


