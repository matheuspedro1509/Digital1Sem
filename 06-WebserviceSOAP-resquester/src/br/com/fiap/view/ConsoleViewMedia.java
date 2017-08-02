package br.com.fiap.view;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularMedia;
import br.com.fiap.bo.CursoBOStub.CalcularMediaResponse;

public class ConsoleViewMedia {

	public static void main(String[] args) {
		// chamar o webservice para calcular media
		
		try{
			CursoBOStub bo = new CursoBOStub();
			
			CalcularMedia valores = new CalcularMedia();
			valores.setAm(7);
			valores.setNac(6);
			valores.setPs(6);
			
			CalcularMediaResponse response = bo.calcularMedia(valores);
			
			double media = response.get_return();
			
			System.out.println("A sua media é"+ media);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
