package br.com.PersistStruts.actions;


import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.PersistStruts.modelo.Cliente;
import br.com.PersistStruts.servicos.ClienteServico;

public class ClienteAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	private List<Cliente> listaCliente;
	
	@Autowired
	ClienteServico clienteServico;
	
	public void validate(){
		if (this.getCliente().getCpf().length()<11){
			addFieldError("cliente.cpf", "CPF INvalido.");
			
		}
	}
	
	
	@SkipValidation	
	public String telaCliente(){
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		return SUCCESS;
	}

	
	public String cadastraCliente(){
		this.addActionMessage(this.clienteServico.salvar(this.getCliente()));
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		
		return SUCCESS;
	}
	@SkipValidation	
	public String pesquisarClienteNome(){
		this.setListaCliente(this.clienteServico.pesquisarClienteNome(this.getCliente()));
		return SUCCESS;
	}
	
	@SkipValidation	
	public String deleteCliente(){
		this.clienteServico.deletarCliente(this.getCliente());
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		return SUCCESS;
	}
	
	@SkipValidation	
	public String atualizaCliente(){
		this.setCliente(this.clienteServico.pesquisarClienteId(this.getCliente()));
		this.setListaCliente(this.clienteServico.pesquisarCliente());
		return SUCCESS;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	

	
	

}
