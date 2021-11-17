package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.repository.AssociadoRepository;
import br.com.api.repository.PartidoRepository;

public class RepositoryService {

	@Autowired
	protected PartidoRepository partidoRepository;
	@Autowired
	protected AssociadoRepository associadoRepository;


	
			
}
