package rest.data.sample.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Response;

@RestController
@RequestMapping("/library/reviews")
public class ReviewsController {
	
	@Autowired
	private ReviewsRepository _reviewRepositry;
	
	@GetMapping(value = "/by-user/{user_id}/")
	public Response getReviewListByUserId(@PathVariable(value = "user_id") String userId) {
		return (new Response(
							"All reviews of user", 
							_reviewRepositry.findByUserId(Long.valueOf(userId))
							)
				);
	}
	@GetMapping(value = "/by-book/{book_id}/")
	public Response getReviewListByBookId(@PathVariable(value = "book_id") String bookId) {
		return (new Response(
							"All book reviews", 
							_reviewRepositry.findByBookId(Long.valueOf(bookId))
							)
				);
	}
}
