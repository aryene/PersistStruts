package br.com.PersistStruts.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistStruts.dao.ProdutoDao;
import br.com.PersistStruts.modelo.Fornecedor;
import br.com.PersistStruts.modelo.Produto;

@Service
public class ProdutoServico {
	
	@Autowired
	ProdutoDao produtoDao;

	@Transactional
	public void salvar(Produto produto) throws Exception {
		produtoDao.save(produto);
	}

	public List<Produto> findAll() {
		return this.produtoDao.findAll();
	}



	public Produto findOne(Integer produtoId) throws Exception {
		return this.produtoDao.findById(produtoId);
	}

	@Transactional
	public void deletar(Produto produto) throws Exception {
		this.produtoDao.delete(this.findOne(produto.getId()));
	}



}
