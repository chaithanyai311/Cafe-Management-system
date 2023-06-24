package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Product;
import com.shopping.service.ProductService;
import com.shopping.utils.DBUtil;

@Service
public class ProductServiceImpl implements ProductService{
	
	static List<Product> productList = new ArrayList<>();
	
	Connection connection;
	
	public ProductServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Connection-----------"+connection);
	}


	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		productList.clear();
		String getProductQuery = "SELECT * FROM PRODUCT";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getProductQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setProductId(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductPrice(rs.getInt(3));
				prod.setProductDescription(rs.getString(4));
				prod.setImageUrl(rs.getString(5));
				prod.setCategoryId(rs.getInt(6));
				
				productList.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		int productid = product.getProductId();
		String productname = product.getProductName();
		int productprice = product.getProductPrice();
		String productdescription = product.getProductDescription();
		String imageurl = product.getImageUrl();
		int categoryid = product.getCategoryId();
		
		String insertQuery="INSERT INTO PRODUCT VALUES("+productid+",'"+productname+"','"+productprice+"','"+productdescription+"','"+imageurl+"','"+categoryid+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Product added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		int productid = product.getProductId();
		String productname = product.getProductName();
		int productprice = product.getProductPrice();
		String productdescription = product.getProductDescription();
		String imageurl = product.getImageUrl();
		int categoryid = product.getCategoryId();;
		
		String updateQuery="UPDATE PRODUCT SET productname='"+productname+"',productprice='"+productprice+"',productdescription='"+productdescription+"',imageurl='"+imageurl+"',categoryid='"+categoryid+"' WHERE productid="+productid+";";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Product info updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM product WHERE productid = "+id+";";
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Product info deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
