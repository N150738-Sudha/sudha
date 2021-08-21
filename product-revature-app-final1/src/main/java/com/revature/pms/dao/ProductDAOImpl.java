package com.revature.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pms.model.Product;
import com.revature.pms.util.DBConnection;

public class ProductDAOImpl implements ProductDAO{
	
	Connection connection = DBConnection.getDBConnection();
	private final String ADD_PRODUCT_QUERY="Insert into hr.products values(?,?,?,?,?)";
	private final String UPDATE_PRODUCT_QUERY="update hr.products set productName=?,quantityOnHand=?,price=?,comments=? where productId=?";
	private final String FIND_ALL_PRODUCT="select * from hr.products";
	private final String DELETE_PRODUCT_QUERY="delete into hr.products where productId=?";
	private final String FIND_PRODUCT_BY_ID_QUERY="select * from hr.products where productId=?";
	private final String FIND_PRODUCT_BY_NAME_QUERY="select * from hr.products where productName=?";
	public boolean addProduct(Product product) {
		int res = 0;		
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_QUERY);
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getQuantityOnHand());
			statement.setInt(4, product.getPrice());
			statement.setString(5, product.getComments());
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res == 0)
			return false;
		else
			return true;
	}

	public boolean deleteProduct(int productId) {
		return false;
		
	}

	public boolean updateProduct(Product product) {
		int res = 0;		
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_QUERY);
			statement.setInt(5, product.getProductId());
			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getQuantityOnHand());
			statement.setInt(3, product.getPrice());
			statement.setString(4, product.getComments());
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res == 0)
			return false;
		else
			return true;
	}

	public Product getProductById(int productId) {
		
		Product prodcut = new Product();
		return null;
	}

	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(FIND_ALL_PRODUCT);
			while (res.next()) {
				Product product = new Product();
				product.setProductId(res.getInt(1));
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
				product.setComments(res.getString(5));
				// product
				// add product to product list
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	

}
