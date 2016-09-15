package br.com.PersistStruts.actions;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.PersistStruts.modelo.Cliente;
import br.com.PersistStruts.modelo.ItemPedido;
import br.com.PersistStruts.modelo.Pedido;
import br.com.PersistStruts.modelo.Produto;
import br.com.PersistStruts.servicos.ClienteServico;
import br.com.PersistStruts.servicos.PedidoServico;
import br.com.PersistStruts.servicos.ProdutoServico;

public class PedidoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Pedido pedido;
	
	private Cliente cliente;
	
	private List<Pedido> listaPedido;
	
	private Produto produto;

	private List<Produto> listaProduto;
	
	private List<ItemPedido> listaItem;
	
	private List<Cliente> listaCliente;
	
	
	@Autowired
	PedidoServico pedidoServico;
	
	@Autowired
	ClienteServico clienteServico;
	
	@Autowired
	ProdutoServico produtoServico;
	
	
	public String telaPedido(){
		this.setListaPedido(this.pedidoServico.findAll());

		
		return "vixi";
	}
	
	public String novoPedido(){
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		this.setListaProduto(this.produtoServico.findAll());
		
		return SUCCESS;
	}
	
	public String cadastraPedido(){
		try {
			this.pedidoServico.salvar(this.pedido,this.listaItem);
			this.addActionMessage("Legal. Salvei o seu Produto");
		} catch (Exception e) {
			this.addActionError("Cara, algum problema aconteceu quando tentei salvar o seu Produto. Foi mal." + e.getMessage());
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public void excluirPedido(){
		try {
			this.pedidoServico.deletar(this.getPedido());
			this.addActionMessage("Legal. Pedido Deletado");
		} catch (Exception e) {
			this.addActionError("Cara, algum problema aconteceu quando tentei salvar o seu Produto. Foi mal." + e.getMessage());
			e.printStackTrace();
		}
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		telaPedido();
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public List<ItemPedido> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemPedido> listaItem) {
		this.listaItem = listaItem;
	}
	
	

	
	

}
