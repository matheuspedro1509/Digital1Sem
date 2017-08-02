package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

		
	
		private Map<Integer,ProdutoTO> banco= new HashMap<>();
		
		public EstoqueBO(){
			banco.put(401,new ProdutoTO(401,"Camiseta Masculina Manga Curta Branca",10,150));
			banco.put(402, new ProdutoTO(402,"Camiseta Feminina Manga Longa Rosa",15,152));
		}
		 public ProdutoTO consultarProduto(int codigo) throws AxisFault{
			ProdutoTO prod=banco.get(codigo);
			if(prod==null)
				throw new AxisFault("Produto nao cadastrado");
			return prod;
		 }
		
		 public List<ProdutoTO> listar(){
			 
			 return  new ArrayList<>(banco.values());
		 }
		/*
		if(codigo==401){
			 return new ProdutoTO(401,"Camiseta Masculina Manga Curta Branca",10,150) ;
		}else if(codigo==402){
			return new ProdutoTO(402,"Camiseta Feminina Manga Longa Rosa",15,152);
			
		}
		*/
		
		
}
