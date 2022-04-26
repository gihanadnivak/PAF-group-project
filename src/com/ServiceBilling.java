package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Billing;

@Path("/Billing")
public class ServiceBilling {
	Billing BillingObj = new Billing();

	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBilling() {
		return BillingObj.readBilling();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBilling(
	 
	 @FormParam("Month") String Month,		
	 @FormParam("Customer_name") String Customer_name,
	 @FormParam("Meter_reading") String Meter_reading,
	 @FormParam("Charge_for_this_month") String Charge_for_this_month,
	 @FormParam("Total_Bill_amount") String Total_Bill_amount)
	{
	 String output = BillingObj.insertBilling(Month, Customer_name, Meter_reading, Charge_for_this_month, Total_Bill_amount);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBilling(String billingData)
	{
	//Convert the input string to a JSON object
	 JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();
	//Read the values from the JSON object
	 String billingId = billingObject.get("billingId").getAsString();
	 String Month = billingObject.get("Month").getAsString();
	 String Customer_name = billingObject.get("Customer_name").getAsString();
	 String Meter_reading = billingObject.get("Meter_reading").getAsString();
	 String Charge_for_this_month = billingObject.get("Charge_for_this_month").getAsString();
	 String Total_Bill_amount = billingObject.get("Total_Bill_amount").getAsString();
	 
	 String output = BillingObj.updateBilling(billingId, Month, Customer_name, Meter_reading, Charge_for_this_month, Total_Bill_amount);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBilling(String billingData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(billingData, "", Parser.xmlParser());
	//Read the value from the element 
	 String billingId = doc.select("billingId").text();
	 String output = BillingObj.deleteBilling(billingId);
	return output;
	
	}
	
}
