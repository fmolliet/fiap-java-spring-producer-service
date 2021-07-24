package br.com.tomatch.producers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tomatch.producers.dto.ProdutorDto;
import br.com.tomatch.producers.form.ProdutorForm;

@RestController
@RequestMapping("")
public class Controller {

	@Autowired
	private ProdutorService service;

	@GetMapping
	@Cacheable(value = "listaProdutores")
	public ResponseEntity<Page<ProdutorDto>> getAll(
			@PageableDefault(sort = "_id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		return service.list(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutorDto> geById(@PathVariable("id") String id) {
		return service.getById(id);

	}

	@PutMapping("/{id}")
	@CacheEvict(value = "listaProdutores", allEntries = true)
	public ResponseEntity<ProdutorDto> update(@PathVariable("id") String id,
			@Valid @RequestBody ProdutorForm produtor) {
		return service.update(id, produtor);

	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "listaProdutores", allEntries = true)
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) {
		return service.delete(id);
	}

	@PostMapping
	@CacheEvict(value = "listaProdutores", allEntries = true)
	public ResponseEntity<ProdutorDto> create(@Valid @RequestBody ProdutorForm form, UriComponentsBuilder uriBuilder) {
		return service.create(form, uriBuilder);
	}

}
