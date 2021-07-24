package br.com.tomatch.producers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutorRepository extends MongoRepository<Produtor, String> {

	void deleteById(String id);

}
