package br.com.fiap.pagamento.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pagamento.domain.Pagamento;
import br.com.fiap.pagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService service;

	@GetMapping(path = "/{id}")
	private ResponseEntity<Pagamento> listPagemento(@PathVariable Integer id) {
		final Pagamento pagamento = service.listPagemento(id);
		return ResponseEntity.ok(pagamento);
	}

	@PutMapping
	private ResponseEntity<Pagamento> efetuarPagamento(@RequestBody Pagamento pagemento) throws URISyntaxException {
		service.efetuarPagamento(pagemento);
		return ResponseEntity.created(new URI("/pagamento/" + pagemento.getId_Pedido())).build();
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Pagamento> cancelearPagamento(@PathVariable Integer id) {
		service.cancelearPagamento(id);
		return ResponseEntity.ok().build();
	}
}