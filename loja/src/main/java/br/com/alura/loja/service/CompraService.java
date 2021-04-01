package br.com.alura.loja.service;

import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.service.model.Compra;

public interface CompraService {
    Compra realizaCompra(CompraDTO compra);
}
