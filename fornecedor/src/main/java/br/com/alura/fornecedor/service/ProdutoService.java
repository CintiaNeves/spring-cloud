package br.com.alura.fornecedor.service;

import br.com.alura.fornecedor.dto.ProdutoDTO;
import br.com.alura.fornecedor.model.Produto;

import java.util.List;

public interface ProdutoService {
    public List<Produto> getProdutosPorEstado(String estado);
    public Produto save(ProdutoDTO produtoDTO);
}
