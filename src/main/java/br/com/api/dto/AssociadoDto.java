package br.com.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.modelo.Associado;

public class AssociadoDto {

	private Long id;
	private String nome;
	private String cargo;
	private String data_nascimento;
	private String sexo;
	private String nomePartido;

	public AssociadoDto(Associado associado) {
		this.id = associado.getId();
		this.nome = associado.getNome();
		this.cargo = associado.getCargo();
		this.data_nascimento = associado.getData_nascimento();
		this.sexo = associado.getSexo();
		this.nomePartido = associado.getPartido().getNome();
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setCargo(String cargo) {

		this.cargo = cargo;
	}

	public void setSexo(String sexo) {

		this.sexo = sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public String getSexo() {
		return sexo;

	}

	public static List<AssociadoDto> converter(List<Associado> associados) {
		return associados.stream().map(AssociadoDto::new).collect(Collectors.toList());

	}

}
