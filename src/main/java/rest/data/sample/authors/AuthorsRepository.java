package rest.data.sample.authors;

import org.springframework.data.repository.CrudRepository;

import rest.data.sample.books.Books;

public interface AuthorsRepository extends CrudRepository<Authors, Long>{
	public Iterable<Authors> findAll();
	
	public Iterable<Authors> findByNameContaining(String str);
}
