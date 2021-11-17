package br.com.api.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.modelo.Associado;
import br.com.api.repository.AssociadoRepository;

public class AtualizacaoAssociadoForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String cargo;
	@NotNull
	private LocalDate data_nascimento;
	@NotNull
	@NotEmpty
	private String sexo;

	@NotNull

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public @NotNull LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(@NotNull LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Associado atualizar(Long id, AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.getOne(id);

		associado.setNome(this.nome);
		associado.setCargo(this.cargo);
		associado.setData_nascimento(this.data_nascimento);
		associado.setSexo(this.sexo);

		return associado;
	}

}
