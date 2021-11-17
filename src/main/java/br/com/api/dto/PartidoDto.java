package br.com.api.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;

public class PartidoDto {

	private Long id;
	private String nome;
	private String sigla;
	private Ideologia ideologia;
	private LocalDate data_fundacao;

	public PartidoDto(Partido partido) {
		this.id = partido.getId();
		this.nome = partido.getNome();
		this.sigla = partido.getSigla();
		this.ideologia = partido.getIdeologia();
		this.data_fundacao = partido.getData_fundacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public LocalDate getData_fundacao() {
		return data_fundacao;
	}

	public static List<PartidoDto> converter(List<Partido> partidos) {
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());

	}

}
