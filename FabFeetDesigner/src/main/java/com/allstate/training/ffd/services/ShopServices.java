package com.allstate.training.ffd.services;

import java.util.List;

import com.allstate.training.ffd.entities.Shop;
import com.allstate.training.ffd.exceptions.BuisnessException;

public interface ShopServices {
	public void addShop(Shop shop) throws BuisnessException;
	public void updateShop(int shopId, String address) throws BuisnessException;
	public void deleteShop(int shopId) throws BuisnessException;
	public Shop getShopById(int shopId) throws BuisnessException;
	public Shop getShopByAddress(String address) throws BuisnessException;
	public List<Shop> getAllShops() throws BuisnessException;
}
