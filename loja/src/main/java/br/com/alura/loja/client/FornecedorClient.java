package br.com.alura.loja.client;

import br.com.alura.loja.dto.InfoFornecedorDTO;
import br.com.alura.loja.dto.InfoPedidoDTO;
import br.com.alura.loja.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@FeignClient("FORNECEDOR")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
