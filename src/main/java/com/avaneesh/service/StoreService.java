package com.avaneesh.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.avaneesh.database.DatabaseConnection;
import com.avaneesh.model.Store;

public class StoreService {
	
	DatabaseConnection dbc = new DatabaseConnection();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	/*public StoreService() {
		stores.put("avaneesh", new Store(1L, "Avaneesh", "chennai", 200001));
	}*/
	
	//This method can be used for Getting all the stores.
	public List<Store> getAllStores() throws Exception {
		List<Store> ls = new ArrayList<Store>();
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "SELECT * FROM store_info ";
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				Store storeobj = new Store();
				storeobj.setId(rs.getLong("Id"));
				storeobj.setAddress(rs.getString("Address"));
				storeobj.setStoreName(rs.getString("name"));
				storeobj.setZipCode(rs.getInt("ZipCode"));
				ls.add(storeobj);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}

	}
	
	//This method used for Getting the specific store.
	public List<Store> getStore(String storeId) throws Exception {
		List<Store> ls = new ArrayList<Store>();
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "SELECT * FROM store_info where id = '" + storeId +"' ";
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				Store storeobj = new Store();
				storeobj.setId(rs.getLong("Id"));
				storeobj.setAddress(rs.getString("Address"));
				storeobj.setStoreName(rs.getString("name"));
				storeobj.setZipCode(rs.getInt("ZipCode"));
				ls.add(storeobj);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}
	}
	
	//This method used for adding a store in Database.
	public String addStore(Store store) throws Exception {
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "INSERT into store_info (name, address, zipcode) VALUES ('" + store.getStoreName() +"' , '" + store.getAddress() +"', '" + store.getZipCode() +"' )";
			stmt.executeUpdate(sqlSelect);
			return "Inserted Succesffuly";
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}
		}
	/*
	public Store updateStore(Store store) {
		if (store.getStoreName().isEmpty()) {
			return null;
		}
		stores.put(store.getStoreName(), store);
		return store;
	}
	*/
	
	//This method used for deleting the store.
	public String removeStore(String storeId) throws Exception {
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "DELETE FROM store_info where id = '" + storeId +"' ";
			stmt.executeQuery(sqlSelect);
			return "Deleted Successfully: '" + storeId +"' ";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}
	}
	
	//The method will be used for searching the stores within the given miles.
	public void serachStore(int miles, int zipCode){
		
		try {
		    URL myURL = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyDgCo_tI9uwWixYXUn1b1cqvxWQBcPeA28");
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		} 
		    
		    catch (MalformedURLException e) { 
		        // new URL() failed
		        // ...
		    } 
		    catch (IOException e) {   
		        // openConnection() failed
		        // ...
		    }
		
	}
	

}
