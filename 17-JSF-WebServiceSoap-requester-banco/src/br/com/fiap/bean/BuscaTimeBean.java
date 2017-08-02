package br.com.fiap.bean;

import br.com.fiap.bo.TimeBOStub;

public class BuscaTimeBean {
	
	
	public void buscar(){
		try{
			TimeBOStub stub = new TimeBOStub();
			
			Buscar params = new Buscar();
			params.setCodigo(codigo);
			BuscarResponse response= stub.buscar(params);
			time=response.get_return();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
