package br.com.fiap.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.PerfumeRepository;
import br.com.fiap.to.Perfume;

@ManagedBean
public class PerfumeBean {

	private Perfume perfume= new Perfume();

	private PerfumeRepository rep = new PerfumeRepository();
	
	//Método para o clique do botao
	public void cadastrar(){
		//mensagem para exibir na tela
		FacesMessage msg;
		try{
			//Chamar o web service
			rep.cadastrar(perfume);
			msg= new FacesMessage("Perfume cadastrado");
		}catch (WebServiceException e) {
			e.printStackTrace();
			msg= new FacesMessage("Erro ao cadastrar");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	
	
	
}
