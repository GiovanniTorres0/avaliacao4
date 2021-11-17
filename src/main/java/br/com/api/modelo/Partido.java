package br.com.api.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sigla;
	private String data_fundacao;
	@Enumerated(EnumType.STRING)
	private Ideologia ideologia = Ideologia.Centro;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");	

	public Partido() {

	}

	public Partido(String nome, String sigla, Ideologia ideologia, String data_fundacao) {
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.data_fundacao = data_fundacao;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(String data_fundacao) {
		data_fundacao = df.format(data_fundacao);
		this.data_fundacao = data_fundacao;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public String getSigla() {
		return sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public Long getId() {
		return id;
	}
}
