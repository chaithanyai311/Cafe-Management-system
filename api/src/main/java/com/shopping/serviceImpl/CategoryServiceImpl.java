package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Category;
import com.shopping.service.CategoryService;
import com.shopping.utils.DBUtil;

@Service
public class CategoryServiceImpl implements CategoryService{

	static List<Category> categoryList = new ArrayList<>();
	
	Connection connection;
	
	public CategoryServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Connection-----------"+connection);
	}
	@Override
	public List<Category> viewAllCategorys() {
		// TODO Auto-generated method stub
		categoryList.clear();
		String getCategoryQuery = "SELECT * FROM CATEGORY";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCategoryQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setCategoryImageUrl(rs.getString(3));
				
				categoryList.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categoryList;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		int categoryid = category.getCategoryId();
		String categoryname = category.getCategoryName();
		String categoryimageurl = category.getCategoryImageUrl();
		
		String insertQuery="INSERT INTO CATEGORY VALUES("+categoryid+",'"+categoryname+"','"+categoryimageurl+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Category added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
		int categoryid = category.getCategoryId();
		String categoryname = category.getCategoryName();
		String categoryimageurl = category.getCategoryImageUrl();
		
		String updateQuery="UPDATE PRODUCT SET categoryname='"+categoryname+"',categoryimageurl='"+categoryimageurl+"' WHERE categoryid="+categoryid+";";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Category info updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM category WHERE categoryid = "+id+";";
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Category info deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
