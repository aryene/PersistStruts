package br.com.PersistStruts.servicos;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.PersistStruts.dao.ClienteDao;
import br.com.PersistStruts.modelo.Cliente;

@Service
public class ClienteServico  {

	@Autowired
	ClienteDao clienteDao; 
	
	
	public String salvar(Cliente cliente){
		String msg ="Cadastro Efetuado";
		try {
			clienteDao.save(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Cliente> pesquisarCliente(){
		return clienteDao.findAll();
	}

	
	public List<Cliente> pesquisarClienteNome(Cliente cliente){
		return clienteDao.findByNamedQuery("Cliente.buscaNome",cliente.getNome());

	}
	
	public Cliente pesquisarClienteId(Cliente cliente){
		return clienteDao.findById(cliente.getId());

	}
	
	public void deletarCliente(Cliente cliente){
		 clienteDao.delete(cliente);

	}





}
