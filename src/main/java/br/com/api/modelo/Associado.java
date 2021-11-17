package br.com.api.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cargo;
	private String data_nascimento;
	private String sexo;
	@ManyToOne
	private Partido partido;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");	
	
	public Associado() {

	}

	public Associado(String nome, String cargo, String data_nascimento, String sexo, Partido partido) {
		this.nome = nome;
		this.cargo = cargo;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.partido = partido;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		data_nascimento = df.format(data_nascimento);
		this.data_nascimento = data_nascimento;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public String getSexo() {
		return sexo;
	}

	public Partido getPartido() {
		return partido;
	}

}
