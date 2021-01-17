package rest.data.sample.books;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

	@Autowired
	private BooksRepository _booksRepository;

	public Iterable<Books> getAllBooks(){
		return _booksRepository.findAll();
	}

	public Optional<Books> getBookById(Long id){
		return _booksRepository.findById(id);
	}

	public Iterable<Books> findBookWithNameThatContains(String str) {
		return _booksRepository.findByNameContaining(str);
	}
	
	public Iterable<Books> findBookReleasedBetween(String from, String to){
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date _fromDate = null;
	    Date _toDate = null;
		try {
			_fromDate = dateFormat.parse(from + "-01-01");
			_toDate = dateFormat.parse(to + "-12-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return _booksRepository.findByReleaseDateBetween(_fromDate, _toDate);
	}
	
	private boolean strContainsInLowerCase(String a, String b) {
		if (a == null || b == null) {
			return false;
		}
		return a.toLowerCase().contains(b.toLowerCase());
	}
	
	public Iterable<Books> findBookReleasedBetweenAndContains(String from, String to, String name){
		return ((List<Books>) findBookReleasedBetween(from, to)).stream()
																.filter(book -> strContainsInLowerCase(book.getName(), name))
																.collect(Collectors.toList());
	}
}
