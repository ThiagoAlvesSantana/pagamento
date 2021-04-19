package br.com.fiap.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pagamento.domain.Pagamento;
import br.com.fiap.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;

	public void efetuarPagamento(Pagamento pagemento) {
		repository.save(pagemento);
	}

	public void cancelearPagamento(Integer id) {
		repository.deleteById(id);
	}
}