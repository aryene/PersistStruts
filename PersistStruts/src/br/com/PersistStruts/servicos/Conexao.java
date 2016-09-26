package br.com.PersistStruts.servicos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Conexao {
	
	  @PersistenceContext(unitName = "JPA")
	  private EntityManager entityManager;
	  
	  
	  @Transactional
		public Connection getConection (){
		
		  Session session = entityManager.unwrap(Session.class);
		  MyWork myWork = new MyWork();
	        session.doWork(myWork);
	        return myWork.getConnection();
/*java.sql.Connection conn = entityManager.unwrap(java.sql.Connection.class);
		
			
			return conn;
			*/
		}
	  private static class MyWork implements Work {

		    Connection conn;

		    @Override
		    public void execute(Connection arg0) throws SQLException {
		        this.conn = arg0;
		    }

		    Connection getConnection() {
		        return conn;
		    }
	  }
}
