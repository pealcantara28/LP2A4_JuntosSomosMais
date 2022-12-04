package com.juntos.services;

import com.juntos.domain.viewmodel.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.juntos.domain.Converter;
import com.juntos.domain.entities.*;
@Service
public class ConverterService {
	public static List<Cliente> convertTempClientes(List<TempCliente> temps)
	{
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		for(TempCliente temp : temps)
		{
			Cliente cliente =  Converter.convertTempToCliente(temp);
			clientes.add(cliente);
		}
		
		return clientes;
	}
}
