package rest.data.sample.tags;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rest.data.sample.books.Books;

@Repository
public class SearchByTagTransaction {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public List<Books> findBooksByTags(Collection<Long> tagIds){
		String jpqlBooksByTagsId = "SELECT b FROM Books b WHERE b.id IN (:b_ids)";
		Query query = entityManager.createQuery(jpqlBooksByTagsId, Books.class);
		query.setParameter("b_ids", getBooksId( tagIds ).stream()
														.map(id->Long.valueOf(id))
														.collect(Collectors.toList()) );
		return (List<Books>) query.getResultList();
	}
	
	private List<Integer> getBooksId(Collection<Long> tagIds){
		String jpqlBooksIdByTagsId = "SELECT bt.book_id FROM book_tag AS bt WHERE bt.tag_id IN (:t_ids)";
		Query query = entityManager.createNativeQuery(jpqlBooksIdByTagsId);
		query.setParameter("t_ids", tagIds);
		return (List<Integer>) query.getResultList();
	}
}
