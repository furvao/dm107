package br.inatel.dm107.logistica.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import br.inatel.dm107.logistica.control.EntregasControl;
import br.inatel.dm107.logistica.model.Entregas;

@Path("/entregas")
@Produces(MediaType.APPLICATION_JSON)
public class EntregasService {
	


	@Context
	private UriInfo uriInfo;

	private EntregasControl entregasControl = new EntregasControl();

	@GET
	public Response findAll() {

		List<Entregas> list = entregasControl.listEntregas();
		if (list != null && list.size() > 0) {
			return Response.ok(list).build();
		} else {
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) {

		Entregas entity = entregasControl.getEntregas(id);
		if (entity != null) {
			return Response.ok(entity).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@PUT
	@Path("/{id}")
	public Response putEntregas(@PathParam("id") Integer id, Entregas entregas) {

		if (id == entregas.getId()) {
			entregasControl.alterarEntregas(entregas);
			return Response.ok(entregas).build();

		} else {
			return Response.status(Status.FORBIDDEN).build();
		}

	}

	@POST
	public Response postEntregas(Entregas entregas) {

		entregasControl.criarEntregas(entregas);

		try {
			return Response.created(new URI(String.format("%s%s", uriInfo.getAbsolutePath(), entregas.getId())))
					.entity(entregas).build();
		} catch (URISyntaxException e) {
			return Response.serverError().build();
		}

	}

	@DELETE
	@Path("/{id}")
	public Response deleteEntregas(@PathParam("id") Integer id) {
		boolean deleted = entregasControl.removerEntregas(id);
		if (deleted) {
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}


}
