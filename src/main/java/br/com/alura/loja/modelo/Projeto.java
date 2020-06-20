package br.com.alura.loja.modelo;

import com.thoughtworks.xstream.XStream;

public class Projeto {

	String nome;
	long id;
	int anoDeInicio;

	public Projeto(long l, String string, int i) {

	}

	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String toXML() {		
		return new XStream().toXML(this);
	}

}
