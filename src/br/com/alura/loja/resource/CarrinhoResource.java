package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@QueryParam("id") long id) throws JsonProcessingException {

		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		return carrinho.json();

	}

	public void exemplo() throws JsonMappingException, JsonProcessingException {

		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		String json = carrinho.json();

		Carrinho readValue = new ObjectMapper().readValue(json, Carrinho.class);
	}

}
