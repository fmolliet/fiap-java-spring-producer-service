package br.com.tomatch.producers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tomatch.producers.dto.ProdutorDto;
import br.com.tomatch.producers.form.ProdutorForm;

@Service
public class ProdutorService {

	@Autowired
	private ProdutorRepository _repository;

	public ResponseEntity<ProdutorDto> getById(String id) {

		Optional<Produtor> produtor = _repository.findById(id);

		return ResponseEntity.ok().body(new ProdutorDto(produtor));
	}

	public ResponseEntity<List<ProdutorDto>> list(Pageable paginacao) {

		try {
			List<Produtor> produtores = new ArrayList<Produtor>();
			_repository.findAll(paginacao).forEach(produtores::add);

			if (produtores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return ResponseEntity.ok().body(ProdutorDto.convertList(produtores));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ProdutorDto> create(ProdutorForm form, UriComponentsBuilder uriBuilder) {
		try {
			Produtor produtor = form.converter();

			_repository.save(produtor);
			URI uri = uriBuilder.path("/produtor/{id}").buildAndExpand(produtor.getId()).toUri();

			return ResponseEntity.created(uri).body(new ProdutorDto(produtor));

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<HttpStatus> delete(String id) {
		try {
			_repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<ProdutorDto> update(String id, @Valid ProdutorForm produtor) {
		Optional<Produtor> produtorData = _repository.findById(id);

		if (produtorData.isPresent()) {
			Produtor _produtor = produtorData.get();

			_produtor.setEmail(produtor.getEmail());
			_produtor.setEndereco(produtor.getEndereco());
			_produtor.setEstado(produtor.getEstado());
			_produtor.setCidade(produtor.getCidade());

			_repository.save(_produtor);

			return ResponseEntity.ok().body(new ProdutorDto(_produtor));
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
