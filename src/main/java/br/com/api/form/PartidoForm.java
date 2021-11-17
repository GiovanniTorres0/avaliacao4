package br.com.api.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;

public class PartidoForm {

	public PartidoForm(@NotNull @NotEmpty String nome, @NotNull @NotEmpty String sigla, @NotNull String data_fundacao,
			@NotNull Ideologia ideologia) {
		this.nome = nome;
		this.sigla = sigla;
		this.data_fundacao = data_fundacao;
		this.ideologia = ideologia;
	}

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sigla;
	@NotNull
	private String data_fundacao;
	@NotNull
	private Ideologia ideologia;
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm");

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public @NotNull String getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(@NotNull String data_fundacao) {
		data_fundacao = df.format(data_fundacao);
		this.data_fundacao = data_fundacao;
	}

	public void setNome(@NotNull String nome) {
		this.nome = nome;
	}

	public void setSigla(@NotNull String sigla) {
		this.sigla = sigla;
	}

	public @NotNull Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(@NotNull Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public Partido retorna() {
		return new Partido(nome, sigla, ideologia, data_fundacao);
	}

}
