package br.com.PersistStruts.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.PersistStruts.modelo.Fornecedor;
import br.com.PersistStruts.modelo.Produto;
import br.com.PersistStruts.servicos.FornecedorServico;
import br.com.PersistStruts.servicos.ProdutoServico;

public class ProdutoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private Produto produto;

	private List<Produto> produtos;
	
	private List<Fornecedor> listaFornecedor;

	@Autowired
	ProdutoServico produtoServico;
	
	@Autowired
	FornecedorServico fornecedorServico;
	


	public String pesquisaProduto() {
		this.setListaFornecedor(this.fornecedorServico.findAll());
		this.produtos = produtoServico.findAll();
		addActionMessage("Legal. Achei a lista de produtos.");
		return SUCCESS;
	}

	public String cadastraProduto() {
		try {
			produtoServico.salvar(this.produto);
			this.addActionMessage("Legal. Salvei o seu Produto");
		} catch (Exception e) {
			this.addActionError("Cara, algum problema aconteceu quando tentei salvar o seu Produto. Foi mal.");
		}
		this.produto = null;
		return this.pesquisaProduto();
	}
	
	public String alterarProduto(){
		try {
			this.produto = this.produtoServico.findOne(produto.getId());
			addActionMessage("Legal. Achei o seu Produto para edição");
		} catch (Exception e) {
			addActionError("Foi mal. Nao achei esse Produto");
		}
		return this.pesquisaProduto();
	}

	public String deletarProduto() {
		try {
			this.produtoServico.deletar(produto);
			this.addActionMessage("Deletei seu Produto. Sem chance de retorno.");
		} catch (Exception e) {
			this.addActionError("Foi mal. Nao consegui deletar seu Produto.");
			e.printStackTrace();
		}
		return this.pesquisaProduto();
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}


	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	

	

}
