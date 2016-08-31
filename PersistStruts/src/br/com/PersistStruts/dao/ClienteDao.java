package br.com.PersistStruts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistStruts.modelo.Cliente;


@Repository
public class ClienteDao {
	
	
	@PersistenceContext(unitName ="JPA")
	protected EntityManager entityManager;
	
	 @Transactional
	  public void salvar(Cliente cliente) throws Exception {
		 entityManager.persist(cliente);
		
	     
	  }
	 
	 public List<Cliente> buscar(){
		return entityManager.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
		
		 
	 }
	 public List<Cliente> buscar(Cliente cliente){
			return entityManager.createNamedQuery("Cliente.buscaNome", Cliente.class).setParameter(1,cliente.getNome()+"%").getResultList();
			
			 
		 }
		 
	
	
}
