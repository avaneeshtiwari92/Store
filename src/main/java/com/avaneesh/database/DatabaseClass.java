package com.avaneesh.database;

import java.util.HashMap;
import java.util.Map;

import com.avaneesh.model.Store;

public class DatabaseClass {
	
	private static Map<String, Store> stores = new HashMap<>();
	
	public static Map<String, Store> getStores() {
		return stores;
	}

}
