package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	public String busca(@PathParam("id") long id) throws JsonProcessingException {
		
		System.out.println(id);			
		
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		System.out.println(carrinho);
		
		return carrinho.json();

	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String adciona(String conteudo) throws JsonMappingException, JsonProcessingException {
				
		System.out.println(conteudo);
		
		Carrinho carrinho = new ObjectMapper().readValue(conteudo, Carrinho.class);
		
		System.out.println(carrinho);
		
		new CarrinhoDAO().adiciona(carrinho);
		return "Status 200";
		
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		
		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		String json = carrinho.json();
		
		System.out.println(json);
		
	}

//	public void exemplo() throws JsonMappingException, JsonProcessingException {
//
//		Carrinho carrinho = new CarrinhoDAO().busca(1l);
//		String json = carrinho.json();
//
//		
//		
//		Carrinho readValue = new ObjectMapper().readValue(json, Carrinho.class);
//	}

}
