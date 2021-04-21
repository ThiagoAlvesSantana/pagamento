package br.com.fiap.pagamento.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Status.TABLE)
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_STATUS";

	public static final Status EM_ANDAMENTO = new Status(1, "Em Andamento");
	public static final Status FECHADO = new Status(2, "Fechado");
	public static final Status PAGO = new Status(3, "Pago");
	public static final Status ENTREGUE = new Status(4, "Entregue");
	public static final Status CANCELADO = new Status(5, "Cancelado");

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_Status;
	private String nome;

	public Status() {
		super();
	}

	public Status(Integer id_Status, String nome) {
		super();
		this.id_Status = id_Status;
		this.nome = nome;
	}

	public Status(Status status) {
		super();
		this.id_Status = status.getId_Status();
		this.nome = status.getNome();
	}

	public Integer getId_Status() {
		return id_Status;
	}

	public void setId_Status(Integer id_Status) {
		this.id_Status = id_Status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Status == null) ? 0 : id_Status.hashCode());
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
		Status other = (Status) obj;
		if (id_Status == null) {
			if (other.id_Status != null)
				return false;
		} else if (!id_Status.equals(other.id_Status))
			return false;
		return true;
	}

}
