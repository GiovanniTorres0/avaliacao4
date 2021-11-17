package br.com.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.dto.AssociadoDto;
import br.com.api.dto.PartidoDto;
import br.com.api.form.AtualizacaoPartidoForm;
import br.com.api.form.PartidoForm;
import br.com.api.modelo.Associado;
import br.com.api.modelo.Ideologia;
import br.com.api.modelo.Partido;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/partidos")
public class PartidoController extends br.com.api.service.RepositoryService {

	
	@ApiOperation(value = "Insere um Partido", notes = "Cadastra um Partido", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@PostMapping
	@Transactional
	public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder) {
		Partido partido = form.retorna();
		partidoRepository.save(partido);

		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PartidoDto(partido));
	}

	
	@ApiOperation(value = "Busca por Ideologia", notes = "Busca por Ideologia", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@GetMapping("/ideologia/{ideologia}")
	public ResponseEntity<List<PartidoDto>> findByIdeologia(@PathVariable Ideologia ideologia) {
		List<Partido> partido = partidoRepository.findPartidoByIdeologia(ideologia);
		if (partido.isEmpty()) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(PartidoDto.converter(partido));
	}

	@ApiOperation(value = "Busca por Id", notes = "Busca por Id", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@GetMapping("/{id}")
	public ResponseEntity<PartidoDto> findByPartidoid(@PathVariable Long id) {
		Optional<Partido> partido = partidoRepository.findById(id);
		if (partido.isPresent()) {
			return ResponseEntity.ok(new PartidoDto(partido.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Busca por Id de associados", notes = "Busca por Id de associados", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })	
	@GetMapping("/{id}/associados")
	public ResponseEntity<List<AssociadoDto>> findByAssociadoId(@PathVariable Long id) {
		List<Associado> associado = associadoRepository.findByPartido_Id(id);
		if (associado.isEmpty()) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(AssociadoDto.converter(associado));
	}

	@ApiOperation(value = "Atualiza por Id", notes = "Atualiza por Id", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoPartidoForm form) {
		Optional<Partido> optional = partidoRepository.findById(id);
		if (optional.isPresent()) {
			Partido partido = form.atualizar(id, partidoRepository);
			return ResponseEntity.ok(new PartidoDto(partido));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta por Id", notes = "Deleta por Id", response = PartidoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Partido> optional = partidoRepository.findById(id);
		if (optional.isPresent()) {
			partidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
