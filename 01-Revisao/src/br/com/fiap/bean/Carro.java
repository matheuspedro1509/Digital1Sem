package br.com.fiap.bean;

public class Carro extends Veiculo {
	
	private Combustivel combustivel;
	
	
	public Carro() {
		super();
	}

	public Carro(int codigo, float peso, String marca, Combustivel combustivel) {
		super(codigo, peso, marca);
		this.combustivel = combustivel;
	}

	public void parar(){
		System.out.println("Carro parando");
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
}
