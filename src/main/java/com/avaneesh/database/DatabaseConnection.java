package com.avaneesh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.avaneesh.model.Store;

public class DatabaseConnection extends Store {
	
	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/stores";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "root");
			return connection;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Store> getStoresAll() throws Exception{
		
		List ls = new ArrayList<>();
		
		Connection con = null;
		
			con =  getConnection();
			
			Statement stmt = con.createStatement();

        String sqlSelect =  "SELECT * FROM store_info ";
        
        ResultSet rs = stmt.executeQuery(sqlSelect);
        while(rs.next()){
        	ls.add(rs);
        }
        return ls;
    }
}