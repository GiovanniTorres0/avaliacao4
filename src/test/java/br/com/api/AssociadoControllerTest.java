package br.com.api;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.api.controller.AssociadoController;
import br.com.api.modelo.Associado;
import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;
import br.com.api.repository.AssociadoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AssociadoControllerTest{

	@Autowired
	private AssociadoRepository associadoRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private	AssociadoController ac;
	
	private Ideologia ideologia = Ideologia.Centro;
	
	@Test
	public void createPersistData() {
		
		Partido partido = new Partido("Partido da Roupa Limpa","PRL", ideologia, "1998-10-11" );
		Associado associado = new Associado("Pedro Alvares", "Prefeito", "1990-10-11","Masculino", partido);
		this.associadoRepository.save(associado);
		Assertions.assertThat(associado.getId()).isNotNull();
		Assertions.assertThat(associado.getNome()).isEqualTo("Pedro Alvares");
		Assertions.assertThat(associado.getCargo()).isEqualTo("Prefeito");
		Assertions.assertThat(associado.getSexo()).isEqualTo("Masculino");
		Assertions.assertThat(associado.getData_nascimento()).isEqualTo("1990-10-11");

	}
	
	
	@Test
	public void deletaAssociado() {
		Partido partido = new Partido("Partido da Roupa Limpa","PRL", ideologia, "1998-10-11" );
		Associado associado = new Associado("Pedro Alvares", "Prefeito", "1990-10-11","Masculino", partido);
		this.associadoRepository.save(associado);
		ac.removerPorId((long) 1);
		
	}
	
	
	
	
	
	
}
