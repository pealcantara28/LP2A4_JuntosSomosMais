package com.juntos.api;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juntos.domain.entities.Cliente;
import com.juntos.domain.viewmodel.TempClienteList;
import com.juntos.services.ClienteService;
import com.juntos.services.ConverterService;
import com.juntos.services.TempClientesService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

//	@SuppressWarnings("unused")
	private ClienteService cliente;
	private TempClientesService tempCliente;
	private ConverterService converter;

	@Autowired
	ClienteController(ClienteService cliente, TempClientesService tempCliente, ConverterService converter) {
		this.cliente = cliente;
		this.tempCliente = tempCliente;
		this.converter = converter;
	}

	@CrossOrigin
	@GetMapping("initial")
	public ResponseEntity getClientesFromUrl() {
		try {
			TempClienteList tempClientes = tempCliente.getTempClientes();

			var clientes = converter.convertTempClientes(tempClientes.getResults());

			cliente.updateClienteDatabase(clientes);

			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@CrossOrigin
	@GetMapping("")
	public ResponseEntity getClientes() {
		try {
			var clientes = cliente.getClientes();
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@CrossOrigin
	@GetMapping("{id}")
	public ResponseEntity getClientes(@PathVariable("id") long id) {
		try {
			var clientes = cliente.getClienteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@CrossOrigin
	@PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity addCliente(@RequestBody Cliente client) {
		try {
			var clientes = cliente.addCliente(client);
			return ResponseEntity.status(HttpStatus.CREATED).body(clientes);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@CrossOrigin
	@PutMapping("")
	public ResponseEntity updateCliente(@RequestBody Cliente client) {
		try {
			var clientes = cliente.updateCliente(client);
			return ResponseEntity.status(HttpStatus.OK).body(clientes);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@CrossOrigin
	@DeleteMapping("")
	public ResponseEntity deleteCliente(@RequestBody Cliente client) {
		try {
			cliente.deleteCliente(client);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
