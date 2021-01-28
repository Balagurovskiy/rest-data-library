package rest.data.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import rest.data.sample.authors.Authors;
import rest.data.sample.authors.AuthorsController;
import rest.data.sample.authors.AuthorsService;
import rest.data.sample.books.Books;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorsController.class)
public class AuthorsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorsService authorsService;

	private Authors _author_1 = new Authors();
	private Authors _author_2 = new Authors();
	
	@Before
	public void init() {
		
		_author_1.setId(1L);
		_author_1.setName("First");
		_author_1.setVersion(777L);
		
		Books _book = new Books();
		
		_book.setName("First Book");
		_author_1.setBooks( Stream.of(_book).collect(Collectors.toSet()) );
		
		_author_2.setId(2L);
		_author_2.setName("Second");
		_author_2.setVersion(0L);
		
		when(authorsService.getAllAuthors()).thenReturn( Arrays.asList(_author_1, _author_2) );
		when(authorsService.getAllBookByAuthorsId(1L)).thenReturn( _author_1.getBooks() );
		when(authorsService.findBookWithNameThatContains("Sec")).thenReturn( Arrays.asList(_author_2) );
		
	}
	
	@Test
	public void getAllAuthors_Test() throws Exception {
		mockMvc.perform( 
						get( "/library/authors/all" )
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Collection of all author entities" )) )
					.andExpect( jsonPath("data[0].id", is( _author_1.getId().intValue() )) )
					.andExpect( jsonPath("data[0].name", is(_author_1.getName())) )
					.andExpect( jsonPath("data[0].version", is( _author_1.getVersion().intValue() )) )
					.andExpect( jsonPath("data[1].id", is( _author_2.getId().intValue() )) )
					.andExpect( jsonPath("data[1].name", is(_author_2.getName())) )
					.andExpect( jsonPath("data[1].version", is( _author_2.getVersion().intValue() )) );
	}
	
	@Test
	public void getAllBookByAuthorsId_Test() throws Exception {
		mockMvc.perform( 
						post( "/library/authors/works" )
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		.content("{\"id\":1, \"data\": \"First\"}")
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Collection of books written by First" )) )
	    	      	
					.andExpect( jsonPath("data[0].name", 
										is( _author_1.getBooks().stream()
																.findFirst()
																.get()
																.getName() 
											)
										) 
							);
	}
	
	@Test
	public void findBookWithNameThatContains_Test() throws Exception {
		mockMvc.perform( 
						get( "/library/authors/name-contains=Sec" )
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Find author that contains Sec in name" )) )
					.andExpect( jsonPath("data[0].id", is( _author_2.getId().intValue() )) )
					.andExpect( jsonPath("data[0].name", is(_author_2.getName())) )
					.andExpect( jsonPath("data[0].version", is( _author_2.getVersion().intValue() )) );
	}
}
