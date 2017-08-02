package br.com.fiap.view;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularPS;
import br.com.fiap.bo.CursoBOStub.CalcularPSResponse;

public class ConsoleView {

	public static void main(String[] args) {
	
		try{
			CursoBOStub bo = new CursoBOStub();
			
			
			//Valores para enviar o webservice
			CalcularPS valores = new CalcularPS();
			valores.setAm(5);
			valores.setNac(5);
			
			//chama o webservice
			CalcularPSResponse response = bo.calcularPS(valores);
			
			//Recuperar o valor retornado pelo webservice
			
			double ps =response.get_return();
			
			System.out.println("Nota necessária na PS: "+ ps);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
