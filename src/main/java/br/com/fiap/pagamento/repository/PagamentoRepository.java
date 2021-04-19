package br.com.fiap.pagamento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.pagamento.domain.Pagamento;

@Repository
public interface PagamentoRepository extends PagingAndSortingRepository<Pagamento, Integer>{

}
