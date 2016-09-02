package br.com.PersistStruts.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_pedido database table.
 * 
 */
@Entity
@Table(name="ITEM_PEDIDO")
@NamedQuery(name="ItemPedido.findAll", query="SELECT i FROM ItemPedido i")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PK pk;

	private int quantidade;

	private float valor;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(cascade=CascadeType.ALL )
	@JoinColumn(name = "PEDIDO_ID",referencedColumnName="ID", insertable=false, updatable=false, nullable=false)
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "PRODUTO_ID",referencedColumnName="ID", insertable=false, updatable=false, nullable=false)
	private Produto produto;

	public ItemPedido() {
		super();
	}

	
	

	public PK getPk() {
		return pk;
	}




	public void setPk(PK pk) {
		this.pk = pk;
	}




	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


@Embeddable
public static class PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUTO_ID")
	private int produtoId;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PEDIDO_ID")
	private int pedidoId;

	public PK() {
		super();
	}
	public int getProdutoId() {
		return this.produtoId;
	}
	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}
	public int getPedidoId() {
		return this.pedidoId;
	}
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PK)) {
			return false;
		}
		PK castOther = (PK)other;
		return 
			(this.produtoId == castOther.produtoId)
			&& (this.pedidoId == castOther.pedidoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.produtoId;
		hash = hash * prime + this.pedidoId;
		
		return hash;
	}
}

}