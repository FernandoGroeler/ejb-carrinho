package br.trabalho;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class SessionBeansStateless implements ISessionBeansStatelessRemote {
	List<Produto> carrinho = new LinkedList<>();

	@Override
	public void addProduto(Produto produto) {
		carrinho.add(produto);
	}

	@Override
	public void removeProduto(Produto produto) {
		carrinho.remove(produto);
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
