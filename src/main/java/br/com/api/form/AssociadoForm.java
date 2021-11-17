package br.com.api.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.MethodArgumentNotValidException;

import br.com.api.modelo.Associado;
import br.com.api.modelo.Partido;
import br.com.api.repository.PartidoRepository;
import br.com.api.validacao.ErroDeValidacaoHandler;

public class AssociadoForm {

	private MethodArgumentNotValidException exception;
	private ErroDeValidacaoHandler ev = new ErroDeValidacaoHandler();

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
	@NotEmpty
	private String nomePartido;

	public String getNome() {
		return nome;
	}

	public String setCargo(String cargo) {
		switch (cargo) {
		case ("vereador"):
			cargo = "Vereador";
			break;
		case ("Vereador"):
			break;
		case ("prefeito"):
			cargo = "Prefeito";
			break;
		case ("Prefeito"):
			break;
		case ("deputado federal"):
			cargo = "Deputado Federal";
			break;
		case ("Deputado Federal"):
			break;
		case ("deputado estadual"):
			cargo = "Deputado Estadual";
			break;
		case ("Deputado Estadual"):
			break;
		case ("senador"):
			cargo = "Senador";
			break;
		case ("Senador"):
			break;
		case ("governador"):
			cargo = "Governador";
			break;
		case ("Governador"):
			break;
		case ("presidente"):
			cargo = "Presidente";
			break;
		case ("Presidente"):
			break;
		case ("nenhum"):
			cargo = "Nenhuma";
			break;
		case ("Nenhum"):
			break;
		default:
			ev.handle(exception);
			break;
		}

		return this.cargo = cargo;
	}

	public LocalDate getData_nascimento() {

		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String setSexo(String sexo) {
		switch (sexo) {
		case ("masculino"):
			sexo = "Masculino";
			break;
		case ("Masculino"):
			break;
		case ("feminino"):
			sexo = "Feminino";
			break;
		case ("Feminino"):
			break;
		default:
			ev.handle(exception);
			break;
		}
		return this.sexo = sexo;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public Associado converter(PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.findByNome(nomePartido);
		return new Associado(nome, cargo, data_nascimento, sexo, partido);
	}

}
