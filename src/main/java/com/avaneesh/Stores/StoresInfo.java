package com.avaneesh.Stores;

import java.io.Serializable;

public class StoresInfo implements Serializable{

		private String storeName;
		private String address;
		private int zipCode;
		
		public StoresInfo(String storeName, String address, int zipCode){
			this.storeName = storeName;
			this.address = address;
			this.zipCode = zipCode;
		}

		public String getStoreName() {
			return storeName;
		}

		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}


}
