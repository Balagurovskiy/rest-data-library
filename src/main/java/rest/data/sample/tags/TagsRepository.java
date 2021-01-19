package rest.data.sample.tags;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import rest.data.sample.books.Books;


public interface TagsRepository extends CrudRepository<Tags, Long>{
	public Iterable<Tags> findAll();
	public Iterable<Tags> findAll(Sort sort);
	
	@Query("SELECT b FROM Books b JOIN b.tags t WHERE t.id IN (:tag_ids) AND b.name LIKE %:book_name%")
	public Iterable<Books> findBooksByTagsAndName(@Param("book_name") String bookName,
													@Param("tag_ids") Collection<Long> tagIds);
}


//@Modifying // use on write queries