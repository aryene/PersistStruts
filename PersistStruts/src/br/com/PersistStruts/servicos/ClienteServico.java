package br.com.PersistStruts.servicos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistStruts.dao.ClienteDao;
import br.com.PersistStruts.modelo.Cliente;

@Service
public class ClienteServico  {

	@Autowired
	ClienteDao clienteDao; 
	
	
	
	public String salvar(Cliente cliente){
		String msg ="Cadastro Efetuado";
		try {
			clienteDao.salvar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Cliente> pesquisarCliente(){
		return clienteDao.buscar();

	}

	
	public List<Cliente> pesquisarClienteNome(Cliente cliente){
		return clienteDao.buscar(cliente);

	}





}
