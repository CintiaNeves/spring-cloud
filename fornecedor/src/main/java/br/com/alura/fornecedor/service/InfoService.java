package br.com.alura.fornecedor.service;

import br.com.alura.fornecedor.dto.FornecedorDTO;
import br.com.alura.fornecedor.model.InfoFornecedor;

public interface InfoService {
    InfoFornecedor getInfoPorEstado(String estado);

    void save(FornecedorDTO fornecedor);
}
