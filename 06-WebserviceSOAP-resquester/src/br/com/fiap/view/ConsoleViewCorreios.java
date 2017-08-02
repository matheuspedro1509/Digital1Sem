package br.com.fiap.view;

import javax.swing.JOptionPane;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrecoPrazoResponse;

public class ConsoleViewCorreios {

	public static void main(String[] args) {
		try {
			CalcPrecoPrazoWSStub bo = new CalcPrecoPrazoWSStub();
			
			//valores para o webservice
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010");
			valores.setSCepDestino(JOptionPane.showInputDialog("Cep Destino"));
			valores.setSCepOrigem(JOptionPane.showInputDialog("Cep origem"));
			
			// chama o webservice dos correios
			CalcPrazoResponse response= bo.calcPrazo(valores);
			
			
			//recuperar a resposta
			String prazo= response.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega();
		
			//System.out.println("Prazo de entrega: "+ prazo);
			JOptionPane.showMessageDialog(null, "Prazo: "+ prazo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
