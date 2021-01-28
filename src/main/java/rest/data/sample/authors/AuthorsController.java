package rest.data.sample.authors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Request;
import rest.data.sample.Response;

@RestController
@RequestMapping("/library/authors")
public class AuthorsController {
 
	@Autowired
	private AuthorsService _authorsService;
	
	@GetMapping(value = "/all")
	public Response getAllAuthors() {
		return (new Response("Collection of all author entities", 
							_authorsService.getAllAuthors())
				);
	}
	@GetMapping(value = "/name-contains={str}")
	public Response findAuthorWithSuchStrInName(@PathVariable(value = "str") String str) {
		return (new Response(
							"Find author that contains " + str + " in name", 
							_authorsService.findBookWithNameThatContains(str)
							)
				);
	}
	
	@PostMapping(value = "/works", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getAllAuthorWorks(@RequestBody Request author) {
		return (new Response("Collection of books written by " + (String) author.getData(), 
							_authorsService.getAllBookByAuthorsId( author.getId()))
				);
	}
}
