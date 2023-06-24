package com.shopping.serviceImpl;

import com.shopping.model.Item;
import com.shopping.service.ItemService;
import com.shopping.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

	static List<Item> itemList = new ArrayList<>();
	Connection connection;
	
	public ItemServiceImpl() throws ClassNotFoundException {
		super();
		connection = DBUtil.getConnection();
		System.out.println("Connection-----------"+connection);
	}
	
	@Override
	public List<Item> viewAllItems() {
		// TODO Auto-generated method stub
		itemList.clear();
		System.out.println("Inside viewAllItem Method");
		
		String getItemQuery = "SELECT * FROM ITEM";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getItemQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Item prod = new Item();
				prod.setItemId(rs.getInt(1));
				prod.setItemName(rs.getString(2));
				prod.setItemPrice(rs.getInt(3));
				prod.setItemDescription(rs.getString(4));
				prod.setImageUrl(rs.getString(5));
				prod.setCategory(rs.getString(6));
				prod.setCustomerId(rs.getInt(1));
				itemList.add(prod);
			}			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("Inside addItem method");
		int itemId = item.getItemId();
		String itemName = item.getItemName();
		int itemPrice = item.getItemPrice();
		String itemDescription = item.getItemDescription();
		String imageUrl = item.getImageUrl();
		String category = item.getCategory();
		int customerId = item.getCustomerId();
		String insertQuery = "INSERT INTO CART(cartName,cartPrice,cartDescription,imageUrl,category,custId,itemId) VALUES('"+itemName+"',"+itemPrice+",'"+itemDescription+"','"+imageUrl+"','"+category+"',"+customerId+","+itemId+");";
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Item added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
