package rest.data.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import rest.data.sample.books.BookService;
import rest.data.sample.books.Books;
import rest.data.sample.books.BooksController;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService _bookService;
	
	private Books _book_1 = new Books();
	private Books _book_2 = new Books();
	
	private final String BOOK_NAME_REQ = "picture";
	
	private final String BOOK_FROM_REQ = "1110";
	private final String BOOK_TO_REQ = "1111";
	
	@Before
	public void init() throws ParseException {
	   SimpleDateFormat _formatter = new SimpleDateFormat("yyyy-MM-dd");  
		
		_book_1.setId(100L);
		_book_1.setName("Great Name");
		_book_1.setReleaseDate( _formatter.parse("1111-11-11") );
		
		_book_2.setId(200L);
		_book_2.setName("Book with pictures");
		_book_2.setReleaseDate( _formatter.parse("2222-11-11") );
		
		when(_bookService.getAllBooks()).thenReturn( Arrays.asList(_book_1, _book_2) );
		when(_bookService.findBookWithNameThatContains(BOOK_NAME_REQ)).thenReturn( Arrays.asList(_book_2) );
		when(_bookService.findBookReleasedBetween(BOOK_FROM_REQ, BOOK_TO_REQ)).thenReturn( Arrays.asList(_book_1) );
	}
	
	@Test
//	@DisplayName("Return json with 2 books ; url : /library/books/all")
	public void getAll_Test() throws Exception {
		mockMvc.perform( 
						get( "/library/books/all" )
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Collection of all book entities" )) )
					.andExpect( jsonPath("data[0].id", is( _book_1.getId().intValue() )) )
					.andExpect( jsonPath("data[1].id", is( _book_2.getId().intValue() )) );
	}
	@Test
//	@DisplayName("Return json with book id:2 ; url : /library/books/name-contains=")
	public void getAllBooksNameCOntains_Test() throws Exception {
		mockMvc.perform( 
						get( "/library/books/name-contains=" + BOOK_NAME_REQ )
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Find book that contains " + BOOK_NAME_REQ + " in name" )) )
					.andExpect( jsonPath("data[0].id", is( _book_2.getId().intValue() )) );
	}
	@Test
//	@DisplayName("Return json with book id:1 ; url : /library/books/released-between?from=1110&to=2220")
	public void getAllBooksBetweenDate_Test() throws Exception {
		mockMvc.perform( 
						get( "/library/books/released-between?from=" + BOOK_FROM_REQ + "&to=" + BOOK_TO_REQ)
	    	      		.contentType(MediaType.APPLICATION_JSON)
	    	      		)
					.andDo(print())
	    	      	.andExpect(status().isOk())
	    	      	.andExpect( jsonPath("description", is( "Find book released between " + BOOK_FROM_REQ + " to " + BOOK_TO_REQ )) )
					.andExpect( jsonPath("data[0].id", is( _book_1.getId().intValue() )) );
	}
}
