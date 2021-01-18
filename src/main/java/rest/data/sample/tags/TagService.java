package rest.data.sample.tags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	public Iterable<Books> getBooksWithThisTag(Collection<Long> tagsId){
		 return _searchByTagTransaction.findBooksByTags( tagsId );
//		 return _tagsRepository.findBooksByTags( tagsId );
//		return _booksRepository.findByTags_IdIn( tagsId );
	}
}
