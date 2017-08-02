package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.PedidoBO;
import br.com.fiap.entity.Pedido;
import br.com.fiap.exception.DBException;

@ManagedBean
public class PedidoBean {

	private Pedido pedido;
	private PedidoBO bo;

	@PostConstruct
	public void iniciar() {
		pedido = new Pedido();
		pedido.setData(Calendar.getInstance());

		bo = new PedidoBO();
	}

	public String cadastrar() {
		FacesMessage msg;
		try {
			if (pedido.getCodigo() != 0) {
				bo.cadastrar(pedido);
				msg = new FacesMessage("Cadastrado parca");
			} else {
				bo.atualizar(pedido);
				msg = new FacesMessage("Atualizou essa fera ai meu");
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "cadastro-pedido";
		}
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-pedido?faces-redirect=true";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
