package br.inatel.dm107.logistica.dao.test;

import java.util.Date;

import br.inatel.dm107.logistica.dao.EntregasDAO;
import br.inatel.dm107.logistica.model.Entregas;

public class EntregasDAOTest {
	
	public static void main(String[] args) {
		
		Entregas entregas = new Entregas();
		entregas.setCpfRecebedor("123456789911");
		entregas.setDataEntrega(new Date());
		entregas.setIdCliente(1);
		entregas.setNomeRecebedor("Fulvio");
		entregas.setNumeroPedido(1);
		
		EntregasDAO dao = new EntregasDAO();
		dao.save(entregas);
		
		System.exit(0);
		
	}

}
