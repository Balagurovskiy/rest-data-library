package rest.data.sample.tags;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import rest.data.sample.authors.Authors;
import rest.data.sample.books.Books;
import rest.data.sample.books.BooksRepository;

@Service
public class TagService {
	
	@Autowired
	private TagsRepository _tagsRepository;
	
	@Autowired
	private BooksRepository _booksRepository;
	
	@Autowired
	private SearchByTagTransaction _searchByTagTransaction;
	
	public Iterable<Tags> getAllTagsOrderByName(){
		return _tagsRepository.findAll( Sort.by("name") );
	}
	
	public Iterable<Tags> getAllTags(){
		return _tagsRepository.findAll();
	}
	
	public Iterable<Books> getBooksWithThisTagAndName(String bookName, Collection<Long> tagsId){
		 return _tagsRepository.findBooksByTagsAndName(bookName, tagsId );
	}
	
	public Iterable<Books> getBooksWithThisTag(Collection<Long> tagsId){
		return _booksRepository.findByTags_IdIn( tagsId );
	}
	
	public Iterable<Authors> getAuthorsWithThisTag(Collection<Long> tagsId){
		 return _searchByTagTransaction.findAuthorsByTags( tagsId );
	}
}
