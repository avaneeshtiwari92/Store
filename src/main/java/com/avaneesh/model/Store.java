package com.avaneesh.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Store {

	
		private long id;
	    private String storeName;
	    private String address;
	    private int zipCode;
	    
	    public Store() {
	    	
	    }
	    
	    public Store(long id, String storeName, String address, int zipCode) {
	    	super();
			this.id = id;
			this.storeName = storeName;
			this.address = address;
			this.zipCode = zipCode;
		}
	    
	    public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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
