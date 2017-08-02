package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Time;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TimeBO {

	public Time buscar(int codigo){
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		TimeDAO dao = new TimeDAOImpl(em);
		
		
		Time time =dao.pesquisar(codigo);
		
		System.out.println("nome:" +time.getNome());
		return time;
	}
	public void cadastrar(Time time) throws AxisFault{
		//Instaciar o entity manager
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		//Instanciar o TimeDAOImpl
		TimeDAO dao = new TimeDAOImpl(em);
		
		//Usar o DAO para cadastrar o time
		try{
			dao.cadastrar(time);
			dao.salvar();//commit no banco
		}catch(DBException e){
			e.printStackTrace();
			throw new AxisFault("Erro ao cadastrar");
		}finally{
			em.close();
		}
	}
	
	
}
