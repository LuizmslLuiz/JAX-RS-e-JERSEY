package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@Path("projeto")
public class ProjetoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca() throws JsonProcessingException {

		Projeto projeto = new ProjetoDAO().busca(1l);
		return projeto.json();
	}

}
