package rest.data.sample.tags;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import rest.data.sample.authors.Authors;


@Repository
public class SearchByTagTransaction {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public List<Authors> findAuthorsByTags(Collection<Long> tagIds){
		String jpqlBooksByTagsId = "SELECT a FROM Authors a WHERE a.id IN (:a_ids)";
		Query query = entityManager.createQuery(jpqlBooksByTagsId, Authors.class);
		query.setParameter("a_ids", getAuthorsId( tagIds ).stream()
														.map(id->Long.valueOf(id))
														.collect(Collectors.toList()) );
		return (List<Authors>) query.getResultList();
	}
	
	private List<Integer> getAuthorsId(Collection<Long> tagIds){
		String jpqlBooksIdByTagsId = "SELECT ab.author_id FROM author_book AS ab JOIN book_tag AS bt ON ab.book_id = bt.book_id WHERE bt.tag_id IN (:t_ids)";
		Query query = entityManager.createNativeQuery(jpqlBooksIdByTagsId);
		query.setParameter("t_ids", tagIds);
		return (List<Integer>) query.getResultList();
	}
}
