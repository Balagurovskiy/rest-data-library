package rest.data.sample.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.data.sample.books.Books;
import rest.data.sample.books.BooksRepository;

@Service
public class AuthorsService {
	@Autowired
	private AuthorsRepository _authorsRepository;
	@Autowired
	private BooksRepository _booksRepository;
	
	
	public Iterable<Authors> getAllAuthors(){
		return _authorsRepository.findAll();
	}
	
	public Iterable<Books> getAllBookByAuthorsId(Long id){
		return _booksRepository.findByAuthorsId(id);
	}
	
	public Iterable<Authors> findBookWithNameThatContains(String str) {
		return _authorsRepository.findByNameContaining(str);
	}
}
