package com.shopping.service;

import java.util.List;

import com.shopping.model.Cartitem;

public interface CartitemService {
	public List<Cartitem> viewAllCartitems(); //Read
	
	public void deleteCartitem(int id); //Delete
}
