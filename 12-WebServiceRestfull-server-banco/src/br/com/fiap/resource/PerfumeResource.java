package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

import br.com.fiap.dao.PerfumeDAO;
import br.com.fiap.dao.impl.PerfumeDAOImpl;
import br.com.fiap.entity.Perfume;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

@Path("/perfume")
public class PerfumeResource {

	private EntityManagerFactory fabrica= EntityManagerFactorySingleton.
			getInstance();
	// /rest/perfume GET
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Perfume> listar(){
		EntityManager em= fabrica.createEntityManager();
		PerfumeDAO dao= new PerfumeDAOImpl(em);
		List<Perfume> lista= dao.listar();
		return lista;
	}
	
	// /rest/perfume POST
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Perfume perfume, @Context UriInfo uriInfo){
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao= new PerfumeDAOImpl(em);
		try{
			dao.cadastrar(perfume);
			dao.salvar();
		}catch(DBException e){
		e.printStackTrace();
		}finally{
			em.close();
		}
		UriBuilder url=UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(perfume.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	// rest/perfume/(codigo) DELETE
	@DELETE
	@Path("/{id}")
	public void remover(int codigo){
		EntityManager em=fabrica.createEntityManager();
		PerfumeDAO dao = new PerfumeDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
	
	// rest/perfume/(codigo) PUT
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id")int codigo,Perfume perfume){
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao = new PerfumeDAOImpl(em);
		perfume.setCodigo(codigo);
		dao.alterar(perfume);
		try{
			dao.salvar();
		}catch (DBException e) {
			e.printStackTrace();
		}
				return Response.ok().build(); //HTTP status 200 ok
	}

	// rest/perfume/(codigo) GET
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Perfume buscar(@PathParam("id")int codigo){
		EntityManager em=fabrica.createEntityManager();
		PerfumeDAO dao = new PerfumeDAOImpl(em);
		Perfume perfume = dao.pesquisar(codigo);
		em.close();
		return perfume;
	}
}
