package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Cartitem;
import com.shopping.model.Customer;
import com.shopping.service.CartitemService;
import com.shopping.utils.DBUtil;

@Service
public class CartitemServiceImpl implements CartitemService{

	static List<Cartitem> cartitemList = new ArrayList<>();
	
	Connection connection;
	
	public CartitemServiceImpl() throws ClassNotFoundException {
		super();
		connection = DBUtil.getConnection();
		System.out.println("Connection-----------"+connection);
		System.out.println();
	}
	
	@Override
	public List<Cartitem> viewAllCartitems() {
		// TODO Auto-generated method stub
		cartitemList.clear();
		String getCartitemQuery = "SELECT * FROM CART";
		System.out.println("Inside viewAllCartitem Method");
		try {
			PreparedStatement stmt = connection.prepareStatement(getCartitemQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cartitem crtitm = new Cartitem();
				Customer cust = new Customer();
					crtitm.setCartId(rs.getInt(1));
					crtitm.setCartName(rs.getString(2));
					crtitm.setCartPrice(rs.getFloat(3));
					crtitm.setCartDescription(rs.getString(4));
					crtitm.setImageUrl(rs.getString(5));
					crtitm.setCategory(rs.getString(6));
					crtitm.setCustId(rs.getInt(7));
					crtitm.setItemId(rs.getInt(8));
					cust.setCustomerId(rs.getInt(1));
					cartitemList.add(crtitm);
			}			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cartitemList;
	}

	@Override
	public void deleteCartitem(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteCartitem method");
		String deleteQuery = "DELETE FROM CART WHERE cartId="+id+";";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Cartitem deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
