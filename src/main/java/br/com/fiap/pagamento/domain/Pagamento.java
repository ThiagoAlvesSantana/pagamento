package br.com.fiap.pagamento.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Pagamento.TABLE)
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_PAGAMENTO";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_Pedido;

	private Integer id_Estabelecimento;
	private Double valor;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Status")
	private Status status;

	public Pagamento() {
		super();
	}

	public Pagamento(Integer id_Pedido, Integer id_Estabelecimento, Double valor, Status status) {
		super();
		this.id_Pedido = id_Pedido;
		this.id_Estabelecimento = id_Estabelecimento;
		this.valor = valor;
		this.status = status;
	}

	public Pagamento(Pagamento pagamento) {
		super();
		this.id_Pedido = pagamento.getId_Pedido();
		this.id_Estabelecimento = pagamento.getId_Estabelecimento();
		this.valor = pagamento.getValor();
		this.status = pagamento.getStatus();
	}

	public Integer getId_Pedido() {
		return id_Pedido;
	}

	public void setId_Pedido(Integer id_Pedido) {
		this.id_Pedido = id_Pedido;
	}

	public Integer getId_Estabelecimento() {
		return id_Estabelecimento;
	}

	public void setId_Estabelecimento(Integer id_Estabelecimento) {
		this.id_Estabelecimento = id_Estabelecimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Pedido == null) ? 0 : id_Pedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id_Pedido == null) {
			if (other.id_Pedido != null)
				return false;
		} else if (!id_Pedido.equals(other.id_Pedido))
			return false;
		return true;
	}
}