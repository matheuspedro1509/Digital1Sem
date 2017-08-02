package br.com.fiap.bo;

public class ImpostoBO {

	public double calcularJuros(double valor,int prazo){
		double total = valor *0.05*prazo;
		return total;
	}
}
