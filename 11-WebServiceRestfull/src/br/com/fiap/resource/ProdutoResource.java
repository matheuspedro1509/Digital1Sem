package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	private ProdutoBO bo = new ProdutoBO();
	
	//buscar
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO bsucar(@PathParam("id")int codigo){
		ProdutoTO produto= bo.buscar(codigo);
		return produto;
	}
	
	//listar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> Listar(){
		return bo.listar();
	}
	
	//cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto,@Context UriInfo uriInfo){
		//cadastrar no banco
		bo.cadastrar(produto);
		//montar a url para acessar o produto criado
		UriBuilder url= UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(produto.getCodigo()));
		//retorna o status HTTP 201 com o link para o recurso criado
		return Response.created(url.build()).build();
	}
	
	//atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id")int codigo,ProdutoTO produto){
		bo.atualizar(produto);
		return Response.ok().build();
	}
	
	//remover 
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id")int id){
		bo.remover(id);
	}
}
