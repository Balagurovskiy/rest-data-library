package rest.data.sample.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Response;
import rest.data.sample.books.BooksRepository;

@RestController
@RequestMapping("/library/tags")
public class TagsController {
	@Autowired
	private TagsRepository rep;
	
	@GetMapping(value = "/all")
	public Response getAllTags() {
		//Make service for this
		return (new Response("Collection of all tag entities", rep.findAll()));
	}
}
