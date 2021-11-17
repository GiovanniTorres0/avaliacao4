package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.modelo.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long>{

	Associado findByNome(String nome);
	
	
	List<Associado> findAssociadoByCargo(String cargo);
	
	
	List<Associado> findByPartido_Id(Long id);
	
}
