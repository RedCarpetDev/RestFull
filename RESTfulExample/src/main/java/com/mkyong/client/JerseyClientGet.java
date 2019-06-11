package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();
			//http://localhost:8282/dictionnaireREST/rest/message/get
			// http://localhost:8282/RESTfulExample/rest/json/metallica/get
			//http://localhost:8282/dictionnaireREST/rest/message/en/msg3?value=See_you
			WebResource webResource = client
					.resource("http://localhost:8282/RESTfulExample/rest/json/metallica/en/getMessages");
			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}