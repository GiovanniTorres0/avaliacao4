package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

	Partido findByNome(String nome);
	
	
	List<Partido> findPartidoByIdeologia(Ideologia ideologia);



	
}
