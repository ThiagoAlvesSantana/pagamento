package br.com.fiap.pagamento.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pagamento.domain.Pagamento;
import br.com.fiap.pagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService service;

	@PutMapping
	private ResponseEntity<Pagamento> efetuarPagamento(Pagamento pagemento) {
		service.efetuarPagamento(pagemento);
		return ResponseEntity.created(new URI("/pagamento/" + pagemento.getNome())).build();
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Pagamento> cancelearPagamento(Long id) {
		service.cancelearPagamento(id);
		return ResponseEntity.ok().build();
	}
}