package br.com.PersistStruts.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistStruts.dao.PedidoDao;
import br.com.PersistStruts.modelo.ItemPedido;
import br.com.PersistStruts.modelo.Pedido;



@Service
public class PedidoServico {
	

	@Autowired
	PedidoDao pedidoDao;
	
/*	@Transactional*/
	public void salvar(Pedido pedido,List<ItemPedido> listaItem) throws Exception {
		pedido = pedidoDao.save(pedido);
		for (ItemPedido itemPedido : listaItem) {
			if(itemPedido.getQuantidade() > 0){
				pedido.addItemPedido(itemPedido);
				pedidoDao.save(pedido);
			}
		}

		
	}
	
	@Transactional
	public void salvarItem(Pedido pedido,List<ItemPedido> listaItem) throws Exception {
		pedido = pedidoDao.save(pedido);
		for (ItemPedido itemPedido : listaItem) {
			if(itemPedido.getQuantidade() > 0){
				pedido.addItemPedido(itemPedido);
				pedidoDao.save(pedido);
			}
		}
		System.out.println("");
		
	}
	
	
	

	public List<Pedido> findAll() {
		return this.pedidoDao.findAll();
	}



	public Pedido findOne(Integer pedidoId) throws Exception {
		return this.pedidoDao.findById(pedidoId);
	}

	@Transactional
	public void deletar(Pedido pedido) throws Exception {
		this.pedidoDao.delete(this.findOne(pedido.getId()));
	}




}
