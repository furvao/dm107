package br.com.inatel.jersey.exercise;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstoqueEntity {

	private List<ProdutoEntity> produtos;

	public EstoqueEntity() {
		super();
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}
	
	
}
