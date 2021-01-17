package rest.data.sample.books;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface BooksRepository extends CrudRepository<Books, Long>{
	public Iterable<Books> findAll();
	
	public Optional<Books> findById(Long id);
	
	public Iterable<Books> findByAuthorsId(Long id);

	public Iterable<Books> findByNameContaining(String str);
	
	public Iterable<Books> findByReleaseDateBetween(Date from, Date to);
}
