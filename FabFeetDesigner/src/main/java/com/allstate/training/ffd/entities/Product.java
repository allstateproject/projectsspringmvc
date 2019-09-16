package com.allstate.training.ffd.entities;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private int productDesignNumber;
	private String productName;
	private String productCategory;
	private int productSize;
	private int productQuantity;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shopId")
	private Shop shop1;
	private String shopName;
	//image
	private int productCost;	
	private Blob productImage;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductDesignNumber() {
		return productDesignNumber;
	}
	public void setProductDesignNumber(int productDesignNumber) {
		this.productDesignNumber = productDesignNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductSize() {
		return productSize;
	}
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Shop getShop() {
		return shop1;
	}
	public void setShop(Shop shop) {
		this.shop1 = shop;
	}
	
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDesignNumber=" + productDesignNumber + ", productName="
				+ productName + ", productCategory=" + productCategory + ", productSize=" + productSize
				+ ", productQuantity=" + productQuantity + ", productCost=" + productCost + ", productImage="
				+ productImage + "]";
	}
	
}
