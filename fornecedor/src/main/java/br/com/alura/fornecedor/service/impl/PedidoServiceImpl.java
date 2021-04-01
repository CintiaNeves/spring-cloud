package br.com.alura.fornecedor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.fornecedor.dto.ItemDoPedidoDTO;
import br.com.alura.fornecedor.model.Pedido;
import br.com.alura.fornecedor.model.PedidoItem;
import br.com.alura.fornecedor.model.Produto;
import br.com.alura.fornecedor.repository.PedidoRepository;
import br.com.alura.fornecedor.repository.ProdutoRepository;
import br.com.alura.fornecedor.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl implements PedidoService {
	

	private final transient PedidoRepository pedidoRepository;
	private final transient ProdutoRepository produtoRepository;
	private transient List<PedidoItem> pedidoItens;

	@Autowired
	public PedidoServiceImpl(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
	}

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
		
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		pedidoItens = itens
			.stream()
			.map(item -> {
				Produto produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				PedidoItem pedidoItem = new PedidoItem();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
		return pedidoItens;
	}
}
