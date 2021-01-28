package rest.data.sample.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.data.sample.Response;
import rest.data.sample.reviews.ReviewsRepository;

@RestController
@RequestMapping("/library/users")
public class UsersController {
	
	@Autowired
	private UsersRepository _usersRepositry;
	
	@GetMapping(value = "/all/")
	public Response getListOfAllUsers() {
		return (new Response(
							"All users", 
							_usersRepositry.findAll()
							)
				);
	}
	@GetMapping(value = "/name-contains/{str}/")
	public Response getUserWithNameThatContains(@PathVariable(value = "str") String str) {
		return (new Response(
							"Fund users with name that ontains " + str, 
							_usersRepositry.findByNameContaining(str)
							)
				);
	}
}
