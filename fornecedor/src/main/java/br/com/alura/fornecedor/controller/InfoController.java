package br.com.alura.fornecedor.controller;

import br.com.alura.fornecedor.dto.FornecedorDTO;
import br.com.alura.fornecedor.model.InfoFornecedor;
import br.com.alura.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
    private final transient InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado){
        LOG.info("Recebendo pedido de informações do fornecedor do estado de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }

    @PostMapping
    public void create(@RequestBody FornecedorDTO fornecedor){
        infoService.save(fornecedor);
    }
}
