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
		List ls = new ArrayList<>();
		try {
			con = dbc.getConnection();
			stmt = con.createStatement();
			String sqlSelect = "SELECT * FROM store_info ";
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) {
				ls.add(rs);
			}
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

		return ls;
	}
	
	/*public Store getStore(String storeName) {
		return stores.get(storeName);
	}
	
	public Store addStore(Store store) {
		store.setId(stores.size() + 1);
		stores.put(store.getStoreName(), store);
		return store;
	}
	
	public Store updateStore(Store store) {
		if (store.getStoreName().isEmpty()) {
			return null;
		}
		stores.put(store.getStoreName(), store);
		return store;
	}
	
	public Store removeStore(String storeName) {
		return stores.remove(storeName);
	}
	*/

}
