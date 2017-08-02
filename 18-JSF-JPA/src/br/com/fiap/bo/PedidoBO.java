package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class PedidoBO {
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

	public List<Pedido> listar() {
		EntityManager em = fabrica.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		List<Pedido> lista = dao.listar();
		em.close();
		return lista;
	}

	public Pedido buscar(int codigo) {
		EntityManager em = fabrica.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		Pedido pedido = dao.pesquisar(codigo);
		em.close();
		return pedido;
	}

	public void cadastrar(Pedido pedido) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		dao.cadastrar(pedido);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void atualizar(Pedido pedido) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		dao.alterar(pedido);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void remover(int codigo) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		PedidoDAO dao = new PedidoDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			em.close();
		}
	}
}
