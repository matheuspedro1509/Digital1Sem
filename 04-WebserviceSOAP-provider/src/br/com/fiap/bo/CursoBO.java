package br.com.fiap.bo;

public class CursoBO {

	public double calcularMedia(double nac, double ps, double am){
		return   nac*0.2 + am*0.3+ ps*0.5;
	}
	
	public double calcularPS(double nac,double am){
		return (6 -(nac*0.2+am*0.3))*2;
	}
	
	public double calcularPSAnual (double nac,double am, double media){
		return(12 -(media + nac*0.2+ am*0.3))*2;
				
	}
}
