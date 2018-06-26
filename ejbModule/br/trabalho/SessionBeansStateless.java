package br.trabalho;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class SessionBeansStateless implements ISessionBeansStatelessRemoteCarrinho {
	List<Produto> carrinho = new LinkedList<>();
	
	private void removeEstoque(int id) {
		Produto prod = getProduto(id);
		double estoque = prod.getEstoque();
		
		prod.setEstoque(estoque - 1);
	}
	
	private void addEstoque(int id) {
		Produto prod = getProduto(id);
		double estoque = prod.getEstoque();
		
		prod.setEstoque(estoque + 1);
	}

	@Override
	public void addProduto(Produto produto) {
		carrinho.add(produto);
		removeEstoque(produto.getId());
	}

	@Override
	public void removeProduto(Produto produto) {
		carrinho.remove(produto);
		addEstoque(produto.getId());
	}

	@Override
	public Produto getProduto(int id) {		
 		for (Produto produto : carrinho) {
			if (produto.getId() == id ) {
				return produto;
			}
		}
		
		return null;
	}

	@Override
	public List<Produto> searchProdutos() {
		return carrinho;
	}

	@Override
	public double getValorTotal() {
		double total = 0;
		
		for (Produto produto : carrinho) {
			total += produto.getPreco();
		}
		
		return total;
	}
}
