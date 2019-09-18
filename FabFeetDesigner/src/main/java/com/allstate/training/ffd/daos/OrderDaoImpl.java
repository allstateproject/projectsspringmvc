package com.allstate.training.ffd.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.entities.OrderDetails;
import com.allstate.training.ffd.entities.Product;
import com.allstate.training.ffd.exceptions.BuisnessException;
import com.allstate.training.ffd.entities.Customer;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	public void updateOrder(int orderId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int totalqty=0;
		int totalcost=0;
		Order order=(Order)session.load(Order.class, orderId);
		Criteria cr=session.createCriteria(OrderDetails.class);
		cr.add(Restrictions.eq("order", order));
		List<OrderDetails> orderDetails=cr.list();
		
		for(OrderDetails o:orderDetails) {
			totalqty+=o.getQty();
		Product	product= o.getProduct();
		totalcost+=product.getProductCost();
		}
		
		order.setTotalqty(totalqty);
		order.setTotalcost(totalcost);
		
		session.update(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateQuantityAndAmount(int orderDetailId, int quantity)throws BuisnessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		OrderDetails orderDeatil=(OrderDetails)session.load(OrderDetails.class, orderDetailId);
		
		orderDeatil.setQty(quantity);
		
		session.update(orderDeatil);
		
		session.getTransaction().commit();
		session.close();
		
		/*
		 * Order order=(Order)session.load(Order.class, orderId);
		 * 
		 * Criteria cr=session.createCriteria(Order.class);
		 * cr.add(Restrictions.eq("orderId", orderId));
		 * 
		 * List<OrderDetails> orderdetails=cr.list();
		 * 
		 * order.setTotalqty()+=orderdetails.getQty();
		 * 
		 * 
		 * 
		 * order.setTotalqty(quantity); session.update(order);
		 * session.getTransaction().commit();
		 */

	}


	public void updatePaymentMethod(int orderId , String paymentType) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Order order=(Order)session.get(Order.class, orderId);
	    order.setPaymentType(paymentType);
		session.update(order);
		session.getTransaction().commit();
	}

	@Override
	public void newOrder(Order ot) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
	     session.beginTransaction();
	     session.save(ot);
	     session.getTransaction().commit();
			
	     session.close();
	}
	
	 public void newOrderDetail(OrderDetails ot) {
		 Session session=sessionFactory.openSession();
	     session.beginTransaction();
	     session.save(ot);
	     session.getTransaction().commit();		
	     session.close();
	 }
	
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
		     session.beginTransaction();
		     Order st=(Order)session.get(Order.class, orderId);
		     session.delete(orderId);
		     session.getTransaction().commit();
				
		     session.close();
	}


	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Order> orders=session.createCriteria(Order.class).list();
		return orders;
		
	}

	@Override
	public List<Order> getOrderByDate(String orderDate) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Order.class);
		cr.add(Restrictions.eq("orderDate", orderDate));
		List<Order> orders=cr.list();
		return orders;
	}

	
	@Override
	public List<Order> getOrderByCustomerId(int cid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Customer customer=(Customer)session.get(Customer.class,cid);
		Criteria cr=session.createCriteria(Order.class);
		cr.add(Restrictions.eq("customer", customer));
		List<Order> orders=cr.list();
		return orders;
	}
	@Override
	public List<Order> getOrderByMonth(String orderDate1, String orderDate2) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Order.class);
		cr.add(Restrictions.between("orderDate",orderDate1, orderDate2));
		List<Order> orders=cr.list();
		return orders;
	}

	}




