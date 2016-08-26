package com.avaneesh.service;

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
	
	public String addStore(String storeName, String address, int ZipCode) throws Exception {
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "INSERT into store_info (name, address, zipcode) VALUES ('" + storeName +"' , '" + address +"', '" + ZipCode +"' )";
			rs = stmt.executeQuery(sqlSelect);
			return "Inserting Succesffuly";
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
				if (rs != null) {
					rs.close();
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
	public String removeStore(String storeId) throws Exception {
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "DELETE FROM store_info where id = '" + storeId +"' ";
			rs = stmt.executeQuery(sqlSelect);
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqlee) {
				sqlee.printStackTrace();
			}
		}
	}
	

}
