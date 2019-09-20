package com.allstate.training.ffd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstate.training.ffd.daos.ShopDao;
import com.allstate.training.ffd.entities.Shop;
import com.allstate.training.ffd.exceptions.BuisnessException;
@Service
public class ShopServicesImpl implements ShopServices {
	
	@Autowired
	ShopDao shopDao;
	@Override
	public void addShop(Shop shop) throws BuisnessException {
		shopDao.addShop(shop);

	}

	@Override
	public void updateShop(int shopId, String address) throws BuisnessException {
		shopDao.updateShop(shopId, address);

	}

	@Override
	public void deleteShop(int shopId) throws BuisnessException {
		shopDao.deleteShop(shopId);

	}

	@Override
	public Shop getShopById(int shopId) throws BuisnessException {
		return shopDao.getShopById(shopId);
	}

	@Override
	public Shop getShopByAddress(String address) throws BuisnessException {
		return shopDao.getShopByAddress(address);
		
	}

	@Override
	public List<Shop> getAllShops() throws BuisnessException {
		return shopDao.getAllShops();
	}

}
