package com.avaneesh.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import com.avaneesh.model.Store;
import com.avaneesh.service.StoreService;

@Path("/store")
@Produces(MediaType.APPLICATION_XML)
public class StoreResources {
	
	private StoreService storeService = new StoreService();
	
	@GET
	@Path("/stores")
	@Produces(MediaType.APPLICATION_XML)
	public List<Store> getStores() throws Exception {
		return storeService.getAllStores();
	}
	
	@GET
	@Path("/{storeId}")
	public List<Store> getStore(@PathParam("storeId") String storeId) throws Exception {
		return storeService.getStore(storeId);
	} 
	  
	 @POST
	public Store addStore(Store store) {
		return storeService.addStore(store);
	}
	
	
	/*
	@PUT
	@Path("/{storeName}")
	public Store updateStore(@PathParam("storeName") String storeName, Store store) {
		store.setStoreName(storeName);
		return storeService.updateStore(store);
	}
	*/
	@DELETE
	@Path("/{storeId}")
	public void deleteStore(@PathParam("storeId") String storeId) throws Exception {
		storeService.removeStore(storeId);
	}
	
}
