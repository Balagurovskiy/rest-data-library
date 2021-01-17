package rest.data.sample.books;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Response;

@RestController
@RequestMapping("/library/books")
public class BooksController {
	@Autowired
	private BookService _bookService;
	
	@GetMapping(value = "/all")
	public Response getAll() {
		return (new Response(
							"Collection of all book entities", 
							_bookService.getAllBooks()
							)
				);
	}
	
	@GetMapping(value = "/name-contains={str}")
	public Response findBookWithSuchStrInName(@PathVariable(value = "str") String str) {
		return (new Response(
							"Find book that contains " + str + " in name", 
							_bookService.findBookWithNameThatContains(str)
							)
				);
	}

	
	@GetMapping(value = "/released-between")
	public Response findBookReleasedBetween(@RequestParam(value = "from", defaultValue = "1") String from,
											@RequestParam(value = "to", defaultValue = "99999") String to) {
		return (new Response(
							"Find book released between " + from + " to " + to, 
							_bookService.findBookReleasedBetween(from, to)
							)
				);
	}
	
	@GetMapping(value = "/find")
	public Response findBookReleasedBetweenAndContains(@RequestParam(value = "name", defaultValue = "") String name,
														@RequestParam(value = "from", defaultValue = "1") String from,
														@RequestParam(value = "to", defaultValue = "99999") String to) {
		return (new Response(
							"Find book released between " + from + " to " + to + " and contains " + name + " in name", 
							_bookService.findBookReleasedBetweenAndContains(from, to, name)
							)
				);
	}
}
