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
import br.com.api.form.AssociadoForm;
import br.com.api.form.AtualizacaoAssociadoForm;
import br.com.api.modelo.Associado;
import br.com.api.modelo.Partido;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/associados")
public class AssociadoController extends br.com.api.service.RepositoryService {

	
	
	
	@ApiOperation(value = "Insere um Associado", notes = "Cadastra um Associado", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@PostMapping
	@Transactional
	public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form,
			UriComponentsBuilder uriBuilder) {
		Associado associado = form.converter(partidoRepository);
		associadoRepository.save(associado);

		URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	}

	@ApiOperation(value = "Cadastra por Partido", notes = "Cadastra por Partido", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@PostMapping("/partidos")
	@Transactional
	public ResponseEntity<AssociadoDto> cadastrarPartido(@RequestBody @Valid AssociadoForm form,
			UriComponentsBuilder uriBuilder) {
		Associado associado = form.converter(partidoRepository);
		associadoRepository.save(associado);

		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	}

	@ApiOperation(value = "Obtém os Associados por Cargo", notes = "Obtém os Associados por Cargo", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })
	@GetMapping("/cargos/{cargo}")
	public ResponseEntity<List<AssociadoDto>> AssociadoPorCargo(@PathVariable String cargo) {
		List<Associado> associado = associadoRepository.findAssociadoByCargo(cargo);
		if (associado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(AssociadoDto.converter(associado));

	}

	@ApiOperation(value = "Obtém os Associados por Id", notes = "Obtém os Associados por Id", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })	
	@GetMapping("/{id}")
	public ResponseEntity<AssociadoDto> AssociadoPorId(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		if (associado.isPresent()) {
			return ResponseEntity.ok(new AssociadoDto(associado.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Atualiza por Id", notes = "Atualiza um Associado por Id", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })		
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoAssociadoForm form) {
		Optional<Associado> optional = associadoRepository.findById(id);
		if (optional.isPresent()) {
			Associado associado = form.atualizar(id, associadoRepository);
			return ResponseEntity.ok(new AssociadoDto(associado));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deleta por Id", notes = "Deleta um Associado por Id", response = AssociadoController.class)
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucesso") })	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerPorId(@PathVariable Long id) {
		Optional<Associado> optional = associadoRepository.findById(id);
		if (optional.isPresent()) {
			associadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Deleta por Id por partido", notes = "Deleta um Associado por Id por partido", response = AssociadoController.class)
	@DeleteMapping("/{id}/partidos/{id}")
	@Transactional
	public ResponseEntity<?> removerPorPartido(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		Optional<Partido> partido = partidoRepository.findById(id);
		
		if (associado.isPresent() && partido.isPresent()) {
			associadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
