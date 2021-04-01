package br.com.alura.fornecedor.service.impl;

import br.com.alura.fornecedor.dto.ProdutoDTO;
import br.com.alura.fornecedor.model.Produto;
import br.com.alura.fornecedor.repository.ProdutoRepository;
import br.com.alura.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private final transient ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	@Override
	public Produto save(ProdutoDTO produtoDTO) {
		return produtoRepository.save(toProduto(produtoDTO));
	}

	private Produto toProduto(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setEstado(produtoDTO.getEstado());
		produto.setNome(produtoDTO.getNome());
		produto.setPreco(produtoDTO.getPreco());
		return produto;
	}
}
