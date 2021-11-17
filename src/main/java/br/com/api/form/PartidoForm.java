package br.com.api.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;

public class PartidoForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sigla;
	@NotNull
	private LocalDate data_fundacao;
	@NotNull
	private Ideologia ideologia;

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public  LocalDate getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(LocalDate data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public void setNome( String nome) {
		this.nome = nome;
	}

	public void setSigla( String sigla) {
		this.sigla = sigla;
	}

	public  Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(@NotNull Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public Partido retorna() {
		return new Partido(nome, sigla, ideologia, data_fundacao);
	}

}
