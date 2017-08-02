package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido,Integer> {

	List<Pedido>listar();
}
