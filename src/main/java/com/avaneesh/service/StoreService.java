package com.avaneesh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.avaneesh.database.DatabaseConnection;
import com.avaneesh.model.Store;

public class StoreService {
	
	DatabaseConnection dbc = new DatabaseConnection();
	
	/*public StoreService() {
		stores.put("avaneesh", new Store(1L, "Avaneesh", "chennai", 200001));
	}*/
	
	public List<Store> getAllStores() throws Exception {
		return dbc.getStoresAll(); 
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
