package br.com.PersistStruts.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.PersistStruts.modelo.Fornecedor;
import br.com.PersistStruts.servicos.FornecedorServico;

public class FornecedorAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private Fornecedor fornecedor;

	private List<Fornecedor> fornecedores;

	@Autowired
	FornecedorServico fornecedorServico;

	public String pesquisaFornecedor() {
		this.fornecedores = fornecedorServico.findAll();
		addActionMessage("Legal. Achei a lista de fornecedores.");
		return SUCCESS;
	}

	public String cadastraFornecedor() {
		try {
			fornecedorServico.salvar(this.fornecedor);
			this.addActionMessage("Legal. Salvei o seu fornecedor");
		} catch (Exception e) {
			this.addActionError("Cara, algum problema aconteceu quando tentei salvar o seu fornecedor. Foi mal.");
		}
		this.fornecedor = null;
		return this.pesquisaFornecedor();
	}
	
	public String alterarFornecedor(){
		try {
			this.fornecedor = this.fornecedorServico.findOne(fornecedor.getId());
			addActionMessage("Legal. Achei o seu Fornecedor para edição");
		} catch (Exception e) {
			addActionError("Foi mal. Nao achei esse Fornecedor");
		}
		return this.pesquisaFornecedor();
	}

	public String deletarFornecedor() {
		try {
			this.fornecedorServico.deletar(fornecedor);
			this.addActionMessage("Deletei seu fornecedor. Sem chance de retorno.");
		} catch (Exception e) {
			this.addActionError("Foi mal. Nao consegui deletar seu fornecedor.");
			e.printStackTrace();
		}
		return this.pesquisaFornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	

	

}
