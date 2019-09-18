package com.allstate.training.ffd.daos;
import java.util.List;

import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.entities.OrderDetails;
import com.allstate.training.ffd.exceptions.BuisnessException;

public interface OrderDao {
	
	public void updateQuantityAndAmount(int orderId, int quantity)throws BuisnessException;
	public void updatePaymentMethod(int orderId , String paymentType);
       public void newOrder(Order ot);
       public void deleteOrder(int orderId);
       public List<Order> getOrderList();
       public List<Order> getOrderByDate(String orderDate);
       public List<Order> getOrderByCustomerId(int cid);
       public List<Order> getOrderByMonth(String orderDate1, String orderDate2);
       public void updateOrder(int orderId);
       public void newOrderDetail(OrderDetails ot);
 /*      public List<Order> getOrderList();
       public List<Order> getOrderByDate();
       public List<Order> getOrderByCustomerId(int cid);
	public void newOrder(Order ot);
	public List<Order> getOrderByCustomerId(Customer c);
	List<Order> getOrderByDate(String orderDate);      */
       
       
}
