package br.com.alura.loja.controller;

import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.service.CompraService;
import br.com.alura.loja.service.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final transient CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        return compraService.realizaCompra(compra);
    }
}
