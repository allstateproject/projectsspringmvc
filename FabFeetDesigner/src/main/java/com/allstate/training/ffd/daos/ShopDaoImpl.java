package com.allstate.training.ffd.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allstate.training.ffd.entities.Shop;
import com.allstate.training.ffd.exceptions.BuisnessException;
@Repository
public class ShopDaoImpl implements ShopDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	/*public ShopDaoImpl() {
		Configuration con=new Configuration().configure().addAnnotatedClass(Shop.class);
	    sessionFactory=con.buildSessionFactory();
	}*/

	@Override
	public void addShop(Shop shop) throws BuisnessException {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(shop);	//insert statement
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateShop(int shopId, String address) throws BuisnessException{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Shop shop1=(Shop)session.get(Shop.class, shopId);
		shop1.setAddress(address);
		session.update(shop1);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteShop(int shopId) throws BuisnessException{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Shop shop1=(Shop)session.get(Shop.class, shopId);
		session.delete(shop1);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Shop getShopById(int shopId) throws BuisnessException{
		Session session=sessionFactory.openSession();
		Shop shop1=(Shop)session.get(Shop.class, shopId);
		session.close();
		return shop1;

	}

	@Override
	public Shop getShopByAddress(String address) throws BuisnessException{
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Shop.class);
		cr.add(Restrictions.eq("Address", address));
		Shop shop=(Shop)cr.uniqueResult();
		return shop;
	}

	@Override
	public List<Shop> getAllShops() throws BuisnessException{
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Shop.class);
		List<Shop> shops=(List<Shop>)cr.list();
		return shops;
	}

}
