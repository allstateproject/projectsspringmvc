package com.allstate.training.ffd.services;

import java.sql.Blob;
import java.util.List;

import com.allstate.training.ffd.entities.Product;
import com.allstate.training.ffd.exceptions.BuisnessException;

public interface ProductService {
	public void addProduct(Product p) throws BuisnessException;
	public List<Product> getProductByShopId(int sid) throws BuisnessException;
	public Product getProductBySizeAndDesign(int size,int design_num) throws BuisnessException;
	public void addProducts(List<Product> p) throws BuisnessException;
	public Product getProductById(int id) throws BuisnessException;
	public List<Product> getProductByCategory(String category) throws BuisnessException;
	public List<Product> getProducts() throws BuisnessException;
	public void updateProductCost(int cost,int pid) throws BuisnessException;
	public void updateProduct(Product p,int c,int q,Blob image) throws BuisnessException;
	public void deleteProduct(int pid) throws BuisnessException;
}
