package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import br.com.fiap.bo.PedidoBO;
import br.com.fiap.entity.Pedido;

public class listaPedidoBean {

	private List<Pedido> lista;
	private PedidoBO bo;
	
	@PostConstruct
	public void inicializacao(){
		bo= new PedidoBO();
		setLista(bo.listar());
	}
	
	public String excluir(int codigo){
		FacesMessage msg;
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}

	public List<Pedido> getLista() {
		return lista;
	}

	public void setLista(List<Pedido> lista) {
		this.lista = lista;
	}
	
}
