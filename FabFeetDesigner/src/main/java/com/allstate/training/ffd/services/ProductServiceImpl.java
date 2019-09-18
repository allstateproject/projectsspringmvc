package com.allstate.training.ffd.services;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.allstate.training.ffd.daos.ProductDao;
import com.allstate.training.ffd.entities.Product;
import com.allstate.training.ffd.exceptions.BuisnessException;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	@Override
	public void addProduct(Product p) throws BuisnessException{
		// TODO Auto-generated method stub
		if(p.getProductName().matches("[a-zA-Z]{1,}")) {
			productDao.addProduct(p);
		}
		throw new BuisnessException("name is invalid");
	}

	@Override
	public List<Product> getProductByShopId(int sid) throws BuisnessException{
		// TODO Auto-generated method stub
		if(sid>0 && sid<=6)
		{
			productDao.getProductByShopId(sid);
		}
		throw new BuisnessException("id is invalid");
		//return null;
	}

	@Override
	public Product getProductBySizeAndDesign(int size, int design_num) throws BuisnessException{
		// TODO Auto-generated method stub
		Product products=productDao.getProductBySizeAndDesign(size, design_num);
		if(products!=null)
		{
			return products;
		}
		else
		{
			throw new BuisnessException("not available");
		}
	}

	@Override
	public void addProducts(List<Product> p) throws BuisnessException{
		// TODO Auto-generated method stub
		productDao.addProducts(p);
	}

	@Override
	public Product getProductById(int id) throws BuisnessException{
		// TODO Auto-generated method stub
		Product p=productDao.getProductById(id);
		return p;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws BuisnessException{
		// TODO Auto-generated method stub
		List<Product> p=productDao.getProductByCategory(category);
		return p;
	}

	@Override
	public List<Product> getProducts() throws BuisnessException{
		// TODO Auto-generated method stub
		List<Product> products=productDao.getProducts();
		if(!products.isEmpty())
		{
			return products;
		}
		else
		{
			throw new BuisnessException("no products");
		}
	}

	@Override
	public void updateProductCost(int cost, int pid) throws BuisnessException{
		// TODO Auto-generated method stub
		productDao.updateProductCost(cost, pid);
	}

	@Override
	public void updateProduct(Product p, int c, int q, Blob image) throws BuisnessException{
		// TODO Auto-generated method stub
		productDao.updateProduct(p, c, q, image);
	}

	@Override
	public void deleteProduct(int pid) throws BuisnessException{
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
	}
	
}
