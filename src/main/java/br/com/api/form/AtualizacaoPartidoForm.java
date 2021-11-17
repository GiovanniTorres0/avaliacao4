package br.com.api.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;
import br.com.api.repository.PartidoRepository;

public class AtualizacaoPartidoForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty

	private String sigla;
	@NotNull

	private Ideologia ideologia;
	@NotNull

	private String data_fundacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public @NotNull String getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(@NotNull String data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public Partido atualizar(Long id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);

		partido.setNome(this.nome);
		partido.setData_fundacao(this.data_fundacao);
		partido.setIdeologia(this.ideologia);
		partido.setSigla(this.sigla);

		return partido;

	}
}
