package rest.data.sample.reviews;


import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository  extends CrudRepository<Reviews, Long>{
	public Iterable<Reviews> findByUserId(Long id);
	public Iterable<Reviews> findByBookId(Long id);
}
