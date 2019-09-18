package com.allstate.training.ffd.services;

import java.util.List;

import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.entities.OrderDetails;
import com.allstate.training.ffd.exceptions.BuisnessException;

public interface OrderService {
	public void updateQuantityAndAmount(int orderId, int quantity) throws BuisnessException;
	public void updatePaymentMethod(int orderId , String paymentType) throws BuisnessException;
       public void newOrder(Order ot) throws BuisnessException;
       public void deleteOrder(int orderId) throws BuisnessException;
       public List<Order> getOrderList() throws BuisnessException;
       public List<Order> getOrderByDate(String orderDate) throws BuisnessException;
       public List<Order> getOrderByCustomerId(int cid) throws BuisnessException;
       public List<Order> getOrderByMonth(String orderDate1, String orderDate2) throws BuisnessException;
       public void updateOrder(int orderId);
       public void newOrderDetail(OrderDetails ot);
}
