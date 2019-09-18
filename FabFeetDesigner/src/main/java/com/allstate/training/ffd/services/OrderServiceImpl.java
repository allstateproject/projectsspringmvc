package com.allstate.training.ffd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstate.training.ffd.daos.OrderDao;
import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.entities.OrderDetails;
import com.allstate.training.ffd.exceptions.BuisnessException;

@Service
public class OrderServiceImpl implements OrderService {
      @Autowired
      OrderDao orderDao;
      
	@Override
	public void updateQuantityAndAmount(int orderId, int quantity) throws BuisnessException{
		
		if(quantity>0) {
		
		orderDao.updateQuantityAndAmount(orderId, quantity);
		}else {
			throw new BuisnessException("qty should be greate than zero");
		}
		

	}

	@Override
	public void updatePaymentMethod(int orderId, String paymentType) throws BuisnessException{
		// TODO Auto-generated method stub
				
		orderDao.updatePaymentMethod(orderId, paymentType);
	}

	@Override
	public void newOrder(Order ot) throws BuisnessException{
		// TODO Auto-generated method stub
		orderDao.newOrder(ot);
	}

	@Override
	public void deleteOrder(int orderId)throws BuisnessException {
		// TODO Auto-generated method stub
       orderDao.deleteOrder(orderId);
	}

	@Override
	public List<Order> getOrderList()throws BuisnessException {
		// TODO Auto-generated method stub
		List<Order> orders=orderDao.getOrderList();
		if(!orders.isEmpty()) {
			return orders;
		}else {
			throw new RuntimeException("No Orders available");
		}
		
	}

	@Override
	public List<Order> getOrderByDate(String orderDate) throws BuisnessException{
		// TODO Auto-generated method stub
		List<Order> orders=orderDao.getOrderByDate(orderDate);
		if(!orders.isEmpty()) {
			return orders;
		}else {
			throw new RuntimeException("No Orders available");
		}
	}

	@Override
	public List<Order> getOrderByCustomerId(int cid) throws BuisnessException {
		// TODO Auto-generated method stub
		List<Order> orders=orderDao.getOrderByCustomerId(cid);
		if(!orders.isEmpty()) {
			return orders;
		}else {
			throw new RuntimeException("No Orders available");
		}
	}

	@Override
	public List<Order> getOrderByMonth(String orderDate1, String orderDate2) throws BuisnessException {
		List<Order> orders=orderDao.getOrderByMonth(orderDate1, orderDate2);
		if(!orders.isEmpty()) {
			return orders;
		}else {
			throw new RuntimeException("No Orders available");
		}
	}

	@Override
	public void updateOrder(int orderId) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(orderId);
	}

	@Override
	public void newOrderDetail(OrderDetails ot) {
		// TODO Auto-generated method stub
		orderDao.newOrderDetail(ot);
		
	}

}
