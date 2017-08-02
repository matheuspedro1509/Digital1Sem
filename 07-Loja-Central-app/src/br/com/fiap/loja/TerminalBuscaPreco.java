package br.com.fiap.loja;

import javax.swing.JOptionPane;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.bo.EstoqueBOStub.ProdutoTO;

public class TerminalBuscaPreco {

	public static void main(String[] args) {
		try {
			System.out.println("o que deseja fazer? \n1 buscar ou \n2 listar");
			int vari=Integer.parseInt(JOptionPane.showInputDialog("Digite o código:"));
			
			
			EstoqueBOStub bo = new EstoqueBOStub();
			
			if(vari== 1){
			ConsultarProduto valores = new ConsultarProduto();
			int codigo= Integer.parseInt
					(JOptionPane.showInputDialog("Digite o código:"));
			valores.setCodigo(codigo);
			
			ConsultarProdutoResponse response = bo.consultarProduto(valores);
			
			ProdutoTO produto = response.get_return();
			JOptionPane.showMessageDialog(null,"Descricao: " +produto.getDescricao()
			                                 + "\nPreço: "+produto.getPrecoUnitario()
			                                 +"\nQuantidade:"+ produto.getQtEstque());
		
			}else if(vari==2){
				Listar valores = new Listar();
				
				
			}else{
				System.out.println("Digite 1 ou 2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
