package com.mkyong.rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Track;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{lang}/{key}")
	public String getMessage(
			@PathParam("lang") String langIsoCode,
			@PathParam("key")String key) {
		System.out.println("Gettttt !!");
		return MessageManager.getInstance().getMessage(langIsoCode, key);
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}
	@GET
	@Path("/{lang}/getMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getAll(@PathParam("lang") String langIsoCode) {

		return MessageManager.getInstance().getMessages(langIsoCode);

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}