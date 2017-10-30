package br.inatel.dm107.logistica.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "entregas")
public class Entregas {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numeroPedido")
	private Integer numeroPedido;

	@Column(name = "idCliente")
	private Integer idCliente;

	@Column(name = "nomeRecebedor")
	private String nomeRecebedor;

	@Column(name = "cpfRecebedor")
	private String cpfRecebedor;

	@Column(name = "dataEntrega")
	private Date dataEntrega;

	public Entregas() {
		super();
	}

	public Entregas(Integer id, Integer numeroPedido, Integer idCliente, String nomeRecebedor, String cpfRecebedor,
			Date dataEntrega) {
		super();
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.idCliente = idCliente;
		this.nomeRecebedor = nomeRecebedor;
		this.cpfRecebedor = cpfRecebedor;
		this.dataEntrega = dataEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public String getCpfRecebedor() {
		return cpfRecebedor;
	}

	public void setCpfRecebedor(String cpfRecebedor) {
		this.cpfRecebedor = cpfRecebedor;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

}
