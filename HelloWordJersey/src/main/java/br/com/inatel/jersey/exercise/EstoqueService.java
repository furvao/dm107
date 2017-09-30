package br.com.inatel.jersey.exercise;

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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiResponse;

import javax.ws.rs.core.Response.Status;

import br.com.inatel.jersey.HelloEntity;

@Api(value = "Estoque")
@Path("/estoque")
@Produces(MediaType.APPLICATION_JSON)
public class EstoqueService {

	@Context
	private UriInfo uriInfo;

	private EstoqueDAO dao = EstoqueDAO.getInstance();

	@GET
	@ApiResponse(response = List.class, code = 200, message = "Lista de Produtos")
	public Response listProdutos() {

		List<ProdutoEntity> list = dao.getEstoque();
		if (list != null && list.size() > 0) {
			return Response.ok(list).build();
		} else {
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/{id}")
	public Response getProduto(@PathParam("id") Long id) {
		ProdutoEntity entity = dao.getItemById(id);
		if (entity != null) {

			return Response.ok(entity).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@GET
	@Path("/qtd/{id}")
	public Response quantidadePorProduto(@PathParam("id") Long id) {
		ProdutoEntity entity = dao.getItemById(id);
		if (entity != null) {

			String retorno = "Existe(m) " + entity.getQtd() + " item (s) de " + entity.getNome() + " em estoque.";
			InformacaoEntity info = new InformacaoEntity();
			info.setInformacao(retorno);

			return Response.ok(info).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@GET
	@Path("/valida/{id}")
	public Response validaEstoqueMinimo(@PathParam("id") Long id) {
		ProdutoEntity entity = dao.getItemById(id);
		if (entity != null) {

			InformacaoEntity info = new InformacaoEntity();
			String retorno = "";

			if (entity.getQtd() < 10) {
				retorno = "Produto com estoque mínimo menor que 10 itens.";

			} else {
				retorno = "Produto com estoque mínimo maior que 10 itens.";
			}

			info.setInformacao(retorno);
			return Response.ok(retorno).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/{id}")
	public Response updateProduto(@PathParam("id") long id, ProdutoEntity entityToUpdate) {

		ProdutoEntity entity = dao.getItemById(id);
		if (entity != null) {

			entity.setNome(entityToUpdate.getNome());

			ProdutoEntity entityUpdated = dao.updateItem(entity);

			return Response.ok(entityUpdated).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@PUT
	@Path("/status/{id}")
	public Response updateStatus(@PathParam("id") long id, String status) {

		if (status.equals("Disponível") || status.equals("Indisponível")) {

			ProdutoEntity entity = dao.getItemById(id);
			if (entity != null) {

				entity.setStatus(status);

				ProdutoEntity entityUpdated = dao.updateItem(entity);

				return Response.ok(entityUpdated).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} else {
			return Response.status(Status.UNAUTHORIZED).build();
		}

	}

	@POST
	public Response criarProduto(ProdutoEntity entity) {

		ProdutoEntity entityCreated = dao.createItem(entity);

		try {
			return Response.created(new URI(String.format("%s%s", uriInfo.getAbsolutePath(), entityCreated.getId())))
					.entity(entityCreated).build();
		} catch (URISyntaxException e) {
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response deleteProduto(@PathParam("id") long id) {
		boolean deleted = dao.delete(id);
		if (deleted) {
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
