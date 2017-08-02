package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Combustivel;
import br.com.fiap.dao.CarroDao;
import br.com.fiap.dao.impl.CarroDaoOracle;
import br.com.fiap.exceptions.BancoException;

public class Teste {
	public static void main(String[] args) {
		//Data -> Calendar
		// Declarar uma variável para armazenar uma data
		Calendar inicioAula;
		//armazenar uma data na variável
		inicioAula=Calendar.getInstance(); //Data atual
		
		//Declarar uma variável para data
		Calendar terminoAula=
							//ano, mes (comeca no 0), dia s
				new GregorianCalendar(2017,Calendar.JUNE,30);
		
		
		// formatar a data
		SimpleDateFormat formatador=
				new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibir as datas...
		System.out.println("Começo: "+formatador.format(inicioAula.getTime()));
		System.out.println("Término: "+formatador.format(terminoAula.getTime()));
		
		//instanciar um carro
		Carro carro= new Carro(1,1000,"Hyundai",Combustivel.FLEX);
	
		//comparar o combustivel
		if(carro.getCombustivel()== Combustivel.DIESEL.FLEX){
			System.out.println("Carro flex");
		}else{
			System.out.println("Carro nao é flex");
		}
		
		//Cadastrar o carro
		CarroDao dao= new CarroDaoOracle();
		try{
			//tenta gravar
		dao.gravar(carro);
		}catch(BancoException e){
			//executa em caso de erro
			e.printStackTrace();
			//exibe a mensagem
			System.err.println(e.getMessage());
		} 
		
	}
}
