package com.avaneesh.Stores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService()
@Path("/store")
public class StoresDetails {
	
	@GET
    @Path("/retrive")
	@Produces("text/html")
	public String selectStore(){
		
		 ResultSet rs = null;
	        String details = ""; 
	        try 
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stores", "root", "root");

	            String query = "select * from STORE_INFO";

	            PreparedStatement st = con.prepareStatement(query);
	            rs = st.executeQuery();

	            details = "<html><body>"; 
	            details = details + "<table border=1>";
	            details = details + "<tr><td><Strong>Id </Strong></td>" +
	                                    "<td><Strong>Name </Strong></td>" + "</tr>";
	            while (rs.next()) 
	            {
	                details = details + "<tr><td>" + rs.getInt("ID") + "</td>" +
	                                        "<td>" + rs.getString("NAME") + "</td></tr>";
	            }
	            details += "</table></body></html>"; 
	        } 
	        catch (Exception e) 
	        {
	            System.out.println(e.getMessage());
	        }   
	        return details;
		
	}

}
