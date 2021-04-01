package br.com.alura.fornecedor.repository;


import br.com.alura.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
