package br.com.alura.fornecedor.service.impl;

import br.com.alura.fornecedor.dto.FornecedorDTO;
import br.com.alura.fornecedor.model.InfoFornecedor;
import br.com.alura.fornecedor.repository.InfoRepository;
import br.com.alura.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private transient InfoRepository repository;

    @Override
    public InfoFornecedor getInfoPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    @Override
    public void save(FornecedorDTO fornecedor) {
        InfoFornecedor infoFornecedor = new InfoFornecedor();
        infoFornecedor.setEndereco(fornecedor.getEndereco());
        infoFornecedor.setEstado(fornecedor.getEstado());
        infoFornecedor.setNome(fornecedor.getNome());
        repository.save(infoFornecedor);
    }
}
