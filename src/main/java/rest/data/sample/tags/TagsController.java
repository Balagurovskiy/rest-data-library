package rest.data.sample.tags;

import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/library/tags")
public class TagsController {
	@Autowired
	private TagService _tagService;
	
	@GetMapping(value = "/all")
	public Response getAllTags() {
		return (new Response(
						"Collection of all tag entities", 
						_tagService.getAllTags())
				);
	}
	@GetMapping(value = "/all-sort-name")
	public Response getAllTagsOrderByName() {
		return (new Response(
						"Collection of all tag entities sorted by name", 
						_tagService.getAllTagsOrderByName())
				);
	}

	private List<Long> collectRequestId(List<Request> requests){
		return (
				requests.stream()
				.map(r -> r.getId())
				.collect(Collectors.toList())
				);
	}
	
	@PostMapping(value = "/books-by-tag", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getBooksWithThisTag(@RequestBody List<Request> requestsWithTagId) {
		return (new Response(
						"Collection of books with selected tags", 
						_tagService.getBooksWithThisTag( collectRequestId(requestsWithTagId) ) )
				);
	}
	
	@PostMapping(value = "/authors-by-tag", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getAuthorsWithThisTag(@RequestBody List<Request> requestsWithTagId) {
		return (new Response(
						"Collection of authors with selected tags", 
						_tagService.getAuthorsWithThisTag( collectRequestId(requestsWithTagId) ) )
				);
	}
	
	@PostMapping(value = "/books-by-tag-name/{bookName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response getAuthorsWithThisTagAndName(@PathVariable(value = "bookName") String bookName,
													@RequestBody List<Request> requestsWithTagId) {
		return (new Response(
						"Collection of authors with selected tags", 
						_tagService.getBooksWithThisTagAndName(bookName, collectRequestId(requestsWithTagId) ) )
				);
	}
	
}
