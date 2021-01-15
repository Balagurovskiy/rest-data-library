package rest.data.sample.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Response;

@RestController
@RequestMapping("/library/authors")
public class AuthorsController {
//	@GetMapping(value = "/all")
//	@PostMapping(value = "/save")
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public Response post(@RequestBody Object o) {
//		
//		// Create Response Object
//		Response response = new Response("Done", o);
//		return response;
//	}

	@Autowired
	private AuthorsRepository rep;
	
	@GetMapping(value = "/all")
	public Response getAllAuthors() {
		//Make service for this
		return (new Response("OK", rep.findAll()));
	}
}
