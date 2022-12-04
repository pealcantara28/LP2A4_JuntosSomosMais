package com.juntos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juntos.domain.entities.Cliente;
import com.juntos.infra.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository repository;
	
	@Autowired
	ClienteService(ClienteRepository cliente){
		this.repository = cliente;
	}
	
	public Cliente getClienteById(long id)
	{
		return this.repository.getById(id);
	}
	
	public List<Cliente> getClientes(){
		return this.repository.getAll();
	}
	
	public List<Cliente> updateClienteDatabase(List<Cliente> clientes)
	{
		return this.repository.saveAll(clientes);
	}
	
	public Cliente addCliente(Cliente cliente)
	{
		return this.repository.save(cliente);
	}
	
	public Cliente updateCliente(Cliente cliente)
	{
		return this.repository.save(cliente);
	}
	
	public void deleteCliente(Cliente cliente)
	{
		this.repository.delete(cliente);
	}
}
