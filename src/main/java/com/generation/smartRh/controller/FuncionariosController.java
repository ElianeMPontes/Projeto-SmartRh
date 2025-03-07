package com.generation.smartRh.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.generation.smartRh.model.Funcionarios;
import com.generation.smartRh.repository.FuncionariosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionariosController {

	@Autowired
	private FuncionariosRepository funcionariosRepository; // instancia de classe no spring

	@GetMapping
	public ResponseEntity<List<Funcionarios>> getAll() {
		return ResponseEntity.ok(funcionariosRepository.findAll());// busca a lista de postagens
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionarios> getById(@PathVariable Long id) {
		return funcionariosRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // busca o item por id
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Funcionarios>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(funcionariosRepository.findAllByNomeContainingIgnoreCase(nome));// busca o item por
																								// nome
	}

	@PostMapping
	public ResponseEntity<Funcionarios> post(@Valid @RequestBody Funcionarios funcionarios) {
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionariosRepository.save(funcionarios));
	}

	@PutMapping
	public ResponseEntity<Funcionarios> put(@Valid @RequestBody Funcionarios funcionarios) {
		return funcionariosRepository.findById(funcionarios.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(funcionariosRepository.save(funcionarios)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Funcionarios> postagem = funcionariosRepository.findById(id);

		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		funcionariosRepository.deleteById(id);
	}
}
