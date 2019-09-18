package com.allstate.training.ffd.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*enum Status{
	delivered, processing, cancel, dispatch;
}
*/
@Entity
public class Order implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private String orderDate,paymentType;
	private int totalqty;
	private float totalcost;
	private String status; 
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;

	@OneToMany(mappedBy="order",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(int totalqty) {
		this.totalqty = totalqty;
	}

	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", paymentType=" + paymentType + ", totalqty="
				+ totalqty + ", totalcost=" + totalcost + ", status=" + status + ", customer=" + customer + "]";
	}
	
	
	

	
	
	
}
