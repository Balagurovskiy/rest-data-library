package rest.data.sample.authors;

import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Authors, Long>{
	public Iterable<Authors> findAll();
}
