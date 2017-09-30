package br.com.inatel.jersey;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldJerseyService {
	
	
	private HelloWordDAO dao = HelloWordDAO.getInstance();

	@GET
	public Response listItems(){
		
		List<HelloEntity> list = dao.getItems();
		if(list != null && list.size() > 0){
			return Response.ok(list).build();
		} else {
			return Response.noContent().build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getHello(@PathParam("id") long id){
		
		HelloEntity entity =dao.getItemById(id);
		if(entity != null){
			return Response.ok(entity).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	
	@PUT
	@Path("/{id}")
	public Response putHello(@PathParam("id") long id, HelloEntity entityToUpdate){
		
		HelloEntity entity = dao.getItemById(id);
		if(entity != null){
			entity.setName(entityToUpdate.getName());
			
			HelloEntity entityUpdated = dao.updateItem(entity);
			
			return Response.ok(entityUpdated).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
	}
	
	@POST
	public Response postHello(HelloEntity entity){
		
		HelloEntity entityCreated = dao.createItem(entity);
		
		return Response.ok(entityCreated).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteHello(@PathParam("id") long id){
		boolean deleted = dao.delete(id);
		if(deleted){
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
