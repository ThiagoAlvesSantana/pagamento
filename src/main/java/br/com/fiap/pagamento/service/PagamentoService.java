package br.com.fiap.pagamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pagamento.domain.Pagamento;
import br.com.fiap.pagamento.domain.Status;
import br.com.fiap.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;

	public Pagamento listPagemento(Integer id) {
		Optional<Pagamento> opPagamento = repository.findById(id);
		return opPagamento.get();
	}

	public void efetuarPagamento(Pagamento pagemento) {
		pagemento.setStatus(Status.PAGO);
		repository.save(pagemento);
	}

	public void cancelearPagamento(Integer id) {
		repository.deleteById(id);
	}
}