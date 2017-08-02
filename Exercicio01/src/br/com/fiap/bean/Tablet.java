package br.com.fiap.bean;

import br.com.fiap.dao.Eletronico;

public class Tablet extends Produto implements Eletronico{
	private String modelo;
	private String marca;
	private String sistemaOperacional;
	private boolean tresG;
	
	
	public void calcular(Tablet tablet){
		double vlGarantia= tablet.getPreco()*0.05;
	}
	public Tablet() {
		super();
	}
	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String sistemaOperacional,
			boolean tresG) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.sistemaOperacional = sistemaOperacional;
		this.tresG = tresG;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	public boolean isTresG() {
		return tresG;
	}
	public void setTresG(boolean tresG) {
		this.tresG = tresG;
	}
	
}
