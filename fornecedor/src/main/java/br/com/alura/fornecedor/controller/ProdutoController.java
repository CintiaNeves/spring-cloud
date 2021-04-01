package br.com.alura.fornecedor.controller;

import br.com.alura.fornecedor.dto.ProdutoDTO;
import br.com.alura.fornecedor.model.Produto;
import br.com.alura.fornecedor.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private final transient ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@RequestMapping("/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}

	@PostMapping
	public void create(@RequestBody ProdutoDTO produto){
		produtoService.save(produto);
	}
}
