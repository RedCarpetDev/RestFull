package com.mkyong.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessageJerseyClient {

	public static void main(String[] args) {
		Client client = Client.create();
		// Faire un put
	
		
		WebResource webResource = client
				   .resource("http://localhost:8282/dictionnaireREST/rest/message/get");

				ClientResponse response = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = response.getEntity(String.class);

				System.out.println("Output from Server .... \n");
				System.out.println(output);
	}

}