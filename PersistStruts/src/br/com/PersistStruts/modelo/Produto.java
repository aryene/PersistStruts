package br.com.PersistStruts.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="PRODUTO")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descricao;

	private float valor;

	//bi-directional many-to-many association to Fornecedor
/*	@ManyToMany(cascade = {CascadeType.ALL})*/
	@ManyToMany
	@JoinTable(
			name="FORNECEDOR_PRODUTO"
			, joinColumns={
				@JoinColumn(name="PRODUTO_ID")
				}
			, inverseJoinColumns={
				@JoinColumn(name="FORNECEDOR_ID")
				}
			)
	private List<Fornecedor> fornecedor;

	//bi-directional many-to-one association to ItemPedido
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itemPedidos;

	public Produto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<Fornecedor> getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);
		itemPedido.setProduto(this);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);
		itemPedido.setProduto(null);

		return itemPedido;
	}

}