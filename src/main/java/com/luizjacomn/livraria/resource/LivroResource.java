package com.luizjacomn.livraria.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.luizjacomn.livraria.model.Livros;
import com.luizjacomn.livraria.repository.LivroRepository;

@Path("/livros")
public class LivroResource {

	private final LivroRepository repo = new LivroRepository();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Livros getLivros() {
		return new Livros(repo.getLivros());
	}

}