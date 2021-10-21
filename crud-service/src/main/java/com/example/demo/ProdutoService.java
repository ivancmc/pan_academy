package com.example.demo;

import java.util.Collection;

public interface ProdutoService {

	public void createProduto(Produto prod);
	public void deleteProduto(String id);
	public Collection<Produto> getProdutos();
}
