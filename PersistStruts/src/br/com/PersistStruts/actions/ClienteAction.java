package br.com.PersistStruts.actions;


import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.PersistStruts.modelo.Cliente;
import br.com.PersistStruts.servicos.ClienteServico;

public class ClienteAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	@Autowired
	ClienteServico clienteServico;

	public String cadastraCliente(){
		this.clienteServico.salvar(this.getCliente());
		System.out.println("passou");
		return SUCCESS;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	

}
