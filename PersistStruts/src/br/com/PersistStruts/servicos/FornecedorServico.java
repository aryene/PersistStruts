package br.com.PersistStruts.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistStruts.dao.FornecedorDao;
import br.com.PersistStruts.modelo.Fornecedor;

@Service
public class FornecedorServico {
	
	@Autowired
	FornecedorDao fornecedorDao;

	@Transactional
	public void salvar(Fornecedor fornecedor) throws Exception {
		fornecedorDao.save(fornecedor);
	}

	public List<Fornecedor> findAll() {
		return this.fornecedorDao.findAll();
	}



	public Fornecedor findOne(Integer fornecedorId) throws Exception {
		return this.fornecedorDao.findById(fornecedorId);
	}

	@Transactional
	public void deletar(Fornecedor fornecedor) throws Exception {
		this.fornecedorDao.delete(this.findOne(fornecedor.getId()));
	}



}
