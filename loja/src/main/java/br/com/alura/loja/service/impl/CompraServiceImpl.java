package br.com.alura.loja.service.impl;

import br.com.alura.loja.client.FornecedorClient;
import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.dto.InfoFornecedorDTO;
import br.com.alura.loja.dto.InfoPedidoDTO;
import br.com.alura.loja.service.CompraService;
import br.com.alura.loja.service.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private transient FornecedorClient fornecedorClient;

    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {

        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compraDTO.getEndereco().getEstado());
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compraDTO.getItens());
        System.out.println(info.getEndereco());

        Compra compra = new Compra();
        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());
        return compra;
    }
}
