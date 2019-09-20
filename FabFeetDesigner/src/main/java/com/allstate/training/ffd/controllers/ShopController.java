package com.allstate.training.ffd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.allstate.training.ffd.entities.Shop;
import com.allstate.training.ffd.exceptions.BuisnessException;
import com.allstate.training.ffd.exceptions.BusinessException;
import com.allstate.training.ffd.services.ShopServices;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ShopServices shopServices;
	
	@RequestMapping("/entershopdetails")
	public ModelAndView setShopDetails(@RequestParam("address")String address) throws BuisnessException {
			ModelAndView mv = new ModelAndView();
			List<Shop> shops;
			try {
			Shop shop = new Shop();
			shop.setAddress(address);
			shopServices.addShop(shop);
			String s = "Shop Added";
			shops = shopServices.getAllShops();
			mv.addObject("message", s);
			mv.addObject("shops", shops);
			mv.setViewName("shoplist");
			
			}catch(Exception e) {
				
				mv.addObject("message", "Shop Not Added");
				mv.setViewName("shoplist");
		}
			return mv;
		}
	}
	

