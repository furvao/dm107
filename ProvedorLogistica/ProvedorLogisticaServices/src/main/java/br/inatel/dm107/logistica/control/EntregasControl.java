package br.inatel.dm107.logistica.control;

import java.util.List;

import org.hibernate.HibernateException;

import br.inatel.dm107.logistica.dao.EntregasDAO;
import br.inatel.dm107.logistica.model.Entregas;

public class EntregasControl {

	private EntregasDAO entregasDAO = new EntregasDAO();

	public void criarEntregas(Entregas entregas) {

		if (entregas != null) {

			try {

				entregasDAO.save(entregas);

			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	}

	public void alterarEntregas(Entregas entregas) {

		if (entregas != null) {

			try {

				Entregas entregasToUpdate = entregasDAO.findById(Entregas.class, entregas.getId());

				if (entregasToUpdate != null) {

					entregasToUpdate.setIdCliente(entregas.getIdCliente());;
					entregasToUpdate.setCpfRecebedor(entregas.getCpfRecebedor());
					entregasToUpdate.setDataEntrega(entregas.getDataEntrega());
					entregasToUpdate.setNomeRecebedor(entregas.getNomeRecebedor());
					entregasToUpdate.setNumeroPedido(entregas.getNumeroPedido());
					entregasDAO.update(entregasToUpdate);

				}

			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean removerEntregas(Integer id) {
		try {

			Entregas EntregasToDelete = entregasDAO.findById(Entregas.class, id);

			if (EntregasToDelete != null) {

				entregasDAO.delete(EntregasToDelete);
				return true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Entregas getEntregas(Integer id) {
		try {

			Entregas Entregas = entregasDAO.findById(Entregas.class, id);

			if (Entregas != null) {

				return Entregas;

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Entregas> listEntregas() {
		return entregasDAO.findAll();
	}


}
