package br.trabalho;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ISessionBeansStatelessRemoteCarrinho {
	void addProduto(Produto produto);
	void removeProduto(Produto produto);
	Produto getProduto(int id);
	List<Produto> searchProdutos();
	double getValorTotal();
}
