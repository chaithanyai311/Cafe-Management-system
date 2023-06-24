package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerService;
import com.shopping.utils.DBUtil;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	static List<Customer> customerList = new ArrayList<>();
	
	Connection connection;
	int flag=0;
	
	public CustomerServiceImpl() throws ClassNotFoundException {
		super();
		connection = DBUtil.getConnection();
		System.out.println("Connection-----------"+connection);
	}
	

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		customerList.clear();
		String getCustomerQuery = "SELECT * FROM CUSTOMER";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCustomerQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setMailId(rs.getString(4));
				cust.setPhone(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setUsername(rs.getString(7));
				cust.setPassword(rs.getString(8));
				
				customerList.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int customerid = customer.getCustomerId();
		String customername = customer.getCustomerName();
		String gender = customer.getGender();
		String mailid = customer.getMailId();
		String phone = customer.getPhone();
		String address = customer.getAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		String insertQuery="INSERT INTO CUSTOMER VALUES("+customerid+",'"+customername+"','"+gender+"','"+mailid+"','"+phone+"','"+address+"','"+username+"','"+password+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		int customerid = customer.getCustomerId();
		String customername = customer.getCustomerName();
		String gender = customer.getGender();
		String mailid = customer.getMailId();
		String phone = customer.getPhone();
		String address = customer.getAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		String updateQuery="UPDATE CUSTOMER SET customername='"+customername+"',gender='"+gender+"',mailid='"+mailid+"',phone='"+phone+"',address='"+address+"',username='"+username+"',password='"+password+"' WHERE customerid="+customerid+";";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer info updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM customer WHERE customerid = "+id+";";
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Customer info deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int loginValidation(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("Inside loginValidation");
		
		try {
			PreparedStatement stmt=connection.prepareStatement("SELECT *FROM CUSTOMER WHERE username='"+username+"'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(7).equals(username) && rs.getString(8).equals(password)) {
					flag=1;
				}
				else {
					System.out.println("Invalid username/password");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
