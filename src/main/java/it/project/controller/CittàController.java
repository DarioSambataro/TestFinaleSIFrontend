package it.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;


import it.project.dto.CittàDto;
import it.project.model.Città;
import it.project.service.CittàService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/città")
public class CittàController {
	@Autowired
	private CittàService cittàService;
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCorso(@RequestBody CittàDto città) {
		try {
			cittàService.insertCittà(città);
			return Response.status(Response.Status.OK).build();
		}
		catch(Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCities() {
		try {
			List<Città> listaCittà = cittàService.getAllCities();
			return Response.status(Response.Status.OK).entity(listaCittà).build();
		}
		catch (Exception ex) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
