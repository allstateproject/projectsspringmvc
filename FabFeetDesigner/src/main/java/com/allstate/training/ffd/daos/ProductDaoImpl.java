package com.allstate.training.ffd.daos;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.allstate.training.ffd.entities.Product;

public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;	
	/*public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
	    sessionFactory=con.buildSessionFactory();
	}*/
	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);	//insert statement
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addProducts(List<Product> products) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		for(Product prod:products)
		{
			session.save(prod);
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product p=(Product)session.get(Product.class, id);
		session.close();
		return p;
		//return null;
	}
	public List<Product> getProductByShopId(int sid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Product.class);
		//List<Product> products=session.createCriteria(Product.class).list();
		cr.add(Restrictions.eq("shopId", sid));
		List<Product> products = cr.list();
		session.close();
		return products;
	}
	public Product getProductBySizeAndDesign(int size, int design_num)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Product.class);
		//List<Product> products=session.createCriteria(Product.class).list();
		Criterion s = Restrictions.eq("productSize", size);
		Criterion n = Restrictions.eq("productDesignNumber",design_num);
		LogicalExpression andExp = Restrictions.and(s,n);
		cr.add( andExp );
		Product product = (Product)cr.uniqueResult();
		session.close();
		return product;
	}
	@Override
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Product.class);
		//List<Product> products=session.createCriteria(Product.class).list();
		cr.add(Restrictions.eq("productCategory", category));
		List<Product> products = cr.list();
		session.close();
		return products;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> products=session.createCriteria(Product.class).list();
		session.close();
		return products;
		//return null;
	}

	@Override
	public void updateProductCost(int cost, int pid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class,pid);
		p.setProductCost(cost);
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateProduct(Product p,int cost,int quantity,Blob productImage) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		p.setProductCost(cost);
		p.setProductQuantity(quantity);
		p.setProductImage(productImage);
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
		session.close();
	}
}
