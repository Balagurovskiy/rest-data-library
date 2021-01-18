package rest.data.sample.authors;

import java.util.List;

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
import rest.data.sample.model.BaseEntity;

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

// @GetMapping(path = "{studentId}")
//    public Student getStudent(@PathVariable("studentId") Integer studentId) {
//        return STUDENTS.stream()
//                .filter(student -> studentId.equals(student.getStudentId()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException(
//                        "Student " + studentId + " does not exists"
//                ));
//    }
	
//	@GetMapping(value = "/find={str}")
//	public Response findBookWithSuchStrInName(@PathVariable String str) {
	
    
//  @RequestMapping(path = "/", produces = "application/json; charset=UTF-8")
//  @ResponseBody
	
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
