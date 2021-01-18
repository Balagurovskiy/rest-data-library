package rest.data.sample.books;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface BooksRepository extends CrudRepository<Books, Long>{
	public Iterable<Books> findAll();
	
	public Optional<Books> findById(Long id);
	
	public Iterable<Books> findByAuthorsId(Long id);

	public Iterable<Books> findByNameContaining(String str);
	
	public Iterable<Books> findByReleaseDateBetween(Date from, Date to);
	
	public Iterable<Books> findByTags_IdIn(Collection<Long> tagIds);
	public Iterable<Books> findByTags_Id(Long tagIds);
}
