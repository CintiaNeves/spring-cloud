package br.com.alura.fornecedor.service;

import br.com.alura.fornecedor.dto.ItemDoPedidoDTO;
import br.com.alura.fornecedor.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido getPedidoPorId(Long id);

    Pedido realizaPedido(List<ItemDoPedidoDTO> produtos);
}
