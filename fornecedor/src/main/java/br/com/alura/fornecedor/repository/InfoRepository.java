package br.com.alura.fornecedor.repository;

import br.com.alura.fornecedor.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {

    InfoFornecedor findByEstado(String estado);
}
