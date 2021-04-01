package br.com.alura.fornecedor.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private String descricao;
    private String estado;
    private String nome;
    private BigDecimal preco;
}
