package br.com.inatel.jersey.exercise;

import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
	
	private static EstoqueDAO estoqueDAO = null;
	private ArrayList<ProdutoEntity> produtosEmEstoque;
	private Long id = 0L;
	
	public static EstoqueDAO getInstance() {
		if (estoqueDAO == null) {
			estoqueDAO = new EstoqueDAO();
		}
		return estoqueDAO;
	}
	
	public EstoqueDAO() {
		produtosEmEstoque = new ArrayList<ProdutoEntity>();
		
	}
	
	public ProdutoEntity getItemByName(String nome) {
		ProdutoEntity item = null;
		for (ProdutoEntity e : produtosEmEstoque) {
			if (e.getNome().equals(nome)) {
				item = e;
				break;
			}
		}
		return item;
	}
	
	public ProdutoEntity getItemById(Long id) {
		ProdutoEntity item = null;
		for (ProdutoEntity e : produtosEmEstoque) {
			if (e.getId().equals(id)) {
				item = e;
				break;
			}
		}
		return item;
	}
	
	
	public ProdutoEntity createItem(ProdutoEntity entity) {
		entity.setId(id);
		entity.setNome(entity.getNome() + " " + id);
		produtosEmEstoque.add(entity);
		id ++;
		return entity;
	}
	
	public ProdutoEntity updateItem (ProdutoEntity entityToUpdate) {
		int index = produtosEmEstoque.indexOf(getItemById(entityToUpdate.getId()));
		produtosEmEstoque.remove(index);
		produtosEmEstoque.add(index, entityToUpdate);
		
		return entityToUpdate;
	}
	
	public List getEstoque() {
		return produtosEmEstoque;
	}

	public boolean delete(Long id){
		ProdutoEntity entity = getItemById(id);
		if (entity != null) {
			produtosEmEstoque.remove(entity);
			return true;
		} else {
			return false;
		}
	}

	
}
