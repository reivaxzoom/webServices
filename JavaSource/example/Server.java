package example;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import example.model.CreateAuthor;
import example.model.RestService;
import hu.elte.txtuml.api.model.API;
import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.execution.ModelExecutor;

@Path("/author")
public class Server {
	private static RestService service;
	private static ModelExecutor executor = ModelExecutor
			.create()
			.setInitialization(() -> {
				service = new RestService();
				Action.start(service);
			})
			.start();

	@POST
	@Path("/")
	public Response createAutor(String name) {
		String result;
		if(service != null) {
			API.send(new CreateAuthor(name), service);
			result = "CREATION OF NEW AUTHOR REQUESTED";
		} else {
			result = "SERVICE NOT YET INITIALIZED";
		}
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAutor(@PathParam("id") String authorID) {
		if(service != null) {
			return service.getNameOf(authorID);
		} else {
			return "SERVICE NOT YET INITIALIZED";
		}
	}

}
