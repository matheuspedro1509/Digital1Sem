package br.com.fiap.repository;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.Perfume;

public class PerfumeRepository {
	private Client cliente = Client.create();
	private static final String URL = "http://localhost:8080/12-WebServiceRestfull-server-banco/rest/perfume/";
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource =cliente.resource(URL + codigo);
		ClientResponse response = resource.delete(ClientResponse.class);

		if(response.getStatus() != 204){
			throw new WebServiceException("HTTP Status:"+ response.getStatus());
		}
	}
	
   public List<Perfume>listar() throws WebServiceException{
	   WebResource resource = cliente.resource(URL);
	   //Acessa o WebService 
	   ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
	   .get(ClientResponse.class);
	   //Validar a resposta
	   if(response.getStatus() != 200){
		   throw new WebServiceException("HTTP status: "+ response.getStatus());
	   }
	   Perfume[] array = response.getEntity(Perfume[].class);
	   return Arrays.asList(array);
   }
   
   
   public Perfume buscar(int codigo) throws WebServiceException{
	   WebResource resource =cliente.resource(URL+ codigo);
	   ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
			   .get(ClientResponse.class);
	   if(response.getStatus() != 200){
		   throw new WebServiceException("Http Status "+ response.getStatus());
	   }
	   return response.getEntity(Perfume.class);
   }
   
   public void cadastrar(Perfume perfume) throws WebServiceException{
	   WebResource resource= cliente.resource(URL);
	   ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
	   .post(ClientResponse.class,perfume);
	   
	   if(response.getStatus() != 201){
		   throw new WebServiceException("HTTP status "+ response.getStatus());
	   }
   }
   
   public void atualizar(Perfume perfume) throws WebServiceException{
	   WebResource resource= cliente.resource(URL+ perfume.getCodigo());
	   ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
			   .put(ClientResponse.class,perfume);
	   if(response.getStatus() !=200){
		   throw new WebServiceException("Http Status: "+ response.getStatus());
	   }
   }
   
}
