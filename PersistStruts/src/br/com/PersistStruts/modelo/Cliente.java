package br.com.PersistStruts.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c order by c.nome"),
		@NamedQuery(name = "Cliente.buscaNome", query = "SELECT c FROM Cliente c where c.nome like ?1  ") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String cnpj;

	private String cpf;

	private String nome;

	@Column(name = "TIPO_CLIENTE")
	private String tipoCliente;

	// bi-directional many-to-one association to Pedido
	/*
	 * @OneToMany(mappedBy="cliente") private List<Pedido> pedidos;
	 */
	public Cliente() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Cliente other = (Cliente) obj;
		if (this.id == 0) {
			if (other.id != 0)
				return false;
		} else if (!(this.id == other.id))
			return false;
		return true;
	}

}