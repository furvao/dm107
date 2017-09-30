package br.com.inatel.jersey.exercise;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformacaoEntity {

	String informacao;

	public InformacaoEntity() {
		super();
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	
	
}
