package com.shopping.service;

import java.util.List;

import com.shopping.model.Item;

public interface ItemService {
	
	public List<Item> viewAllItems(); //Read

	public void addItem(Item item); //Create

}
