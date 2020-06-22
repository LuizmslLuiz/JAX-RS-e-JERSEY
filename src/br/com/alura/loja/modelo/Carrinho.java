package br.com.alura.loja.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

public class Carrinho {

	private List<Produto> produtos = new ArrayList<Produto>();
	private String rua;
	private String cidade;
	private long id;

	public Carrinho() {
		super();
	}

	public Carrinho adiciona(Produto produto) {
		produtos.add(produto);
		return this;
	}

	public Carrinho para(String rua, String cidade) {
		this.rua = rua;
		this.cidade = cidade;
		return this;
	}

	public void remove(long id) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			if (produto.getId() == id) {
				produtos.remove(i);
				break;
			}
		}
	}

	public void troca(Produto produto) {
		remove(produto.getId());
		adiciona(produto);
	}

	public void trocaQuantidade(Produto produto) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			if (p.getId() == produto.getId()) {
				p.setQuantidade(produto.getQuantidade());
				return;
			}
		}
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String json() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + ", rua=" + rua + ", cidade=" + cidade + ", id=" + id + "]";
	}

}
