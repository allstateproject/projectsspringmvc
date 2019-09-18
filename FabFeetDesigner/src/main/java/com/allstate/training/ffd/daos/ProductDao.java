package com.allstate.training.ffd.daos;

import java.sql.Blob;
import java.util.List;

import com.allstate.training.ffd.entities.Product;

public interface ProductDao {
	public void addProduct(Product p);
	public void addProducts(List<Product> p);
	public List<Product> getProductByShopId(int sid);
	public Product getProductBySizeAndDesign(int size, int design_num);
	public Product getProductById(int id);
	public List<Product> getProductByCategory(String category);
	public List<Product> getProducts();
	public void updateProductCost(int cost,int pid);
	public void updateProduct(Product p,int c,int q,Blob image);
	public void deleteProduct(int pid);
}
