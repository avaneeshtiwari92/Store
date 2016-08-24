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

import com.avaneesh.model.Store;
import com.avaneesh.service.StoreService;

@Path("/stores")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResources {
	
	private StoreService storeService = new StoreService();
	
	@GET
	public List<Store> getStores() throws Exception {
		return storeService.getAllStores();
	}
	
	/*@POST
	public Store addStore(Store store) {
		return storeService.addStore(store);
	}
	
	@GET
	@Path("/{storeName}")
	public Store getStore(@PathParam("storeName") String storeName) {
		return storeService.getStore(storeName);
	}
	
	@PUT
	@Path("/{storeName}")
	public Store updateStore(@PathParam("storeName") String storeName, Store store) {
		store.setStoreName(storeName);
		return storeService.updateStore(store);
	}
	
	@DELETE
	@Path("/{storeName}")
	public void deleteStore(@PathParam("storeName") String storeName) {
		storeService.removeStore(storeName);
	}*/
	
}
