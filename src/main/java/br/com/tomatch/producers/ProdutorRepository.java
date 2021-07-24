package br.com.tomatch.producers;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutorRepository extends MongoRepository<Produtor, String> {

	List<Produtor> findByNome(String nome);

	List<Produtor> findByDocumment(String documment);

	void deleteById(String id);

}
