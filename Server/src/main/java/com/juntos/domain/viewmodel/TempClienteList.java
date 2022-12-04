package com.juntos.domain.viewmodel;

import java.util.List;

public class TempClienteList {

	public List<TempCliente> results;

	public TempClienteList(List<TempCliente> results) {
		this.results = results;
	}

	public TempClienteList() {
		// TODO Auto-generated constructor stub
	}

	public List<TempCliente> getResults() {
		return results;
	}

	public void setResults(List<TempCliente> results) {
		this.results = results;
	}
}
