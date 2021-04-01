package br.com.alura.loja.service.impl;

import br.com.alura.loja.client.FornecedorClient;
import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.dto.InfoFornecedorDTO;
import br.com.alura.loja.dto.InfoPedidoDTO;
import br.com.alura.loja.service.CompraService;
import br.com.alura.loja.service.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompraServiceImpl implements CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraServiceImpl.class);
    @Autowired
    private transient FornecedorClient fornecedorClient;

    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {
        final String estado = compraDTO.getEndereco().getEstado();

        LOG.info("Buscando informações do fornecedor de {}", estado);
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

        LOG.info("Realizando um pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compraDTO.getItens());

        Compra compra = new Compra();
        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());
        return compra;
    }
}
