package com.allstate.training.ffd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Shop {

	private int shopId;
	private String Address;
	@OneToMany(mappedBy="shop", cascade=CascadeType.ALL)
	private List<Product> products=new ArrayList<Product>();
	@OneToMany(mappedBy="shop", cascade=CascadeType.ALL)
	private List<Employees> shop=new ArrayList();
	
}
