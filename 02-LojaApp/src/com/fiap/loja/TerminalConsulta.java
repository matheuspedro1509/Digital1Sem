package com.fiap.loja;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiap.bo.EstoqueBO;
import com.fiap.loja.to.ProdutoTO;



public class TerminalConsulta {
	
	private static Logger log = LoggerFactory.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		log.info("Inicio da alicação");
		
		int codigo=0;
		Calendar  dataHoje;
		dataHoje=Calendar.getInstance();
		SimpleDateFormat formatador=  new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("FIAP                                  Data:"+ formatador.format(dataHoje.getTime()) );
		System.out.println("*****************************************************");
		Scanner entrada= new Scanner(System.in);
		System.out.print("Código do produto:");
	    codigo=entrada.nextInt();
	    
	    switch(codigo){
	    case 401:
	    	System.out.println("Camiseta Masculina Manga Curta Branca");
	    	break;
	    case 402:
	    	System.out.println("Camiseta Feminina Manga Longa Rosa");
	    	break;
	    default:
	    	System.out.println("Produto não encontrado");
	    }
	    
	    //Parte aprimorada do exercicio
	    EstoqueBO bo = new EstoqueBO();
	    ProdutoTO produto= new ProdutoTO();
	    if(produto!= null){
	    	log.debug("Produto encontrado: "+produto.getDescricao());
	    	System.out.println("Quantidade: "+ produto.getQtEstque());
	    	DecimalFormat format = new DecimalFormat("R$ ##,###.00");
	    	System.out.println("Preço: "+ format.format(produto.getPrecoUnitario()));
	    }else{
	    	log.debug("Produto nao cadastrado: "+ codigo);
	    }
	    entrada.close();
	}

}
