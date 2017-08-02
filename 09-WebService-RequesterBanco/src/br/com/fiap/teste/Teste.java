package br.com.fiap.teste;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Time;

public class Teste {

	public static void main(String[] args) {
		try {
			//Instanciar o stub
			TimeBOStub stub= new TimeBOStub();
			
			//instanciar a classe com o mesmo nome do metodo
			Cadastrar params = new Cadastrar();
			
			//Instanciar o time
			Time time = new Time();
			time.setNome("Java");
			time.setTitulos(1);
			time.setTurma("td");
			
			//setar o time na classe cadastrar
			params.setTime(time);
			
			//chamar o metodo cadastrar do stub
			stub.cadastrar(params);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
