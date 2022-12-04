package com.juntos.services;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntos.domain.entities.Coordinates;
import com.juntos.domain.entities.Dates;
import com.juntos.domain.entities.Location;
import com.juntos.domain.entities.Name;
import com.juntos.domain.entities.Picture;
import com.juntos.domain.entities.Timezone;
import com.juntos.domain.viewmodel.TempCliente;
import com.juntos.domain.viewmodel.TempClienteList;

@Service
public class TempClientesService {
	private HttpClient client;

	@Autowired
	public TempClientesService() {
		this.client = HttpClient.newHttpClient();
	}

	public TempClienteList getTempClientes() throws Exception {
		var tempCliente1 = getTempClientesFromJson();
		var tempCliente2 = getTempClientesFromCSV();

		List<TempCliente> tempClientes = new ArrayList<TempCliente>();

		tempClientes.addAll(tempCliente1.getResults());
		tempClientes.addAll(tempCliente2.getResults());

		return new TempClienteList(tempClientes);
	}

	public TempClienteList getTempClientesFromJson() throws Exception {
		// Criamos um objeto URL com a URL da requisição
		URL url = new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json");

		// Abrimos uma conexão HTTP com a URL
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

		// Definimos o método da requisição como GET
		conexao.setRequestMethod("GET");

		// Obtemos o código de resposta da requisição
		int codigoResposta = conexao.getResponseCode();

		// Verificamos se a requisição foi bem-sucedida (código de resposta 200)
		if (codigoResposta == 200) {
			// Se sim, criamos um leitor de caracteres para ler a resposta
			BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

			// Armazenamos a resposta em uma string vazia
			String resposta = "";

			// Lendo a resposta linha por linha e adicionando à string de resposta
			String linha = leitor.readLine();
			while (linha != null) {
				resposta += linha;
				linha = leitor.readLine();
			}

			// Fechamos o leitor
			leitor.close();

			ObjectMapper mapeador = new ObjectMapper();

			TempClienteList tempCliente = mapeador.readValue(resposta, TempClienteList.class);

			// Imprimimos a resposta
			return tempCliente;
		} else {
			// Se a requisição não foi bem-sucedida, imprimimos o código de resposta
			return new TempClienteList();
		}
	}

	public TempClienteList getTempClientesFromCSV() throws Exception {
		// Cria uma nova URL a partir da string fornecida
		URL url = new URL("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.csv");

		// Cria um novo BufferedReader a partir da URL
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		// Cria uma lista vazia para armazenar os objetos da classe X
		List<TempCliente> list = new ArrayList<>();

		// Lê o primeiro linha do arquivo CSV (a linha de cabeçalho)
		String line = reader.readLine();

		// Divide a linha em campos usando a vírgula como separador
		String[] headers = line.split(",");

		// Lê as linhas restantes do arquivo CSV
		while ((line = reader.readLine()) != null) {
			// Divide a linha em campos usando a vírgula como separador
			String[] fields = line.split("\",");
			for(int i = 0; i<fields.length;i++)
			{
				fields[i] = fields[i].replace("\"","");	
			}

			TempCliente cliente = new TempCliente();
			cliente.setGender(fields[0]);

			var name = new Name();
			name.setTitle(fields[1]);
			name.setFirst(fields[2]);
			name.setLast(fields[3]);
			cliente.setName(name);

			var location = new Location();
			location.setStreet(fields[4]);
			location.setCity(fields[5]);
			location.setState(fields[6]);
			location.setPostcode(Integer.parseInt(fields[7]));
			var coordinates = new Coordinates();
			coordinates.setLatitude(Double.parseDouble(fields[8]));
			coordinates.setLongitude(Double.parseDouble(fields[9]));
			location.setCoordinates(coordinates);
			var timezone = new Timezone();
			timezone.setOffset(fields[10]);
			timezone.setDescription(fields[11]);
			location.setTimezone(timezone);
			cliente.setLocation(location);

			cliente.setEmail(fields[12]);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

			var dob = new Dates();
			dob.setDate(sdf.parse(fields[13]));
			dob.setAge(Integer.parseInt(fields[14]));
			cliente.setDob(dob);

			var registered = new Dates();
			registered.setDate(sdf.parse(fields[15]));
			registered.setAge(Integer.parseInt(fields[16]));
			cliente.setRegistered(registered);

			cliente.setPhone(fields[17]);
			cliente.setCell(fields[18]);

			var picture = new Picture();
			picture.setLarge(fields[19]);
			picture.setMedium(fields[20]);
			picture.setThumbnail(fields[21]);
			cliente.setPicture(picture);

			list.add(cliente);
		}

		// Fecha o BufferedReader
		reader.close();

		return new TempClienteList(list);
	}
}
