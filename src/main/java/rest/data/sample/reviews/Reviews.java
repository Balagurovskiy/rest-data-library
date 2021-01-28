package rest.data.sample.reviews;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import rest.data.sample.books.Books;
import rest.data.sample.model.BaseEntity;
import rest.data.sample.users.Users;

@Entity
@Table(name = "reviews")
public class Reviews extends BaseEntity{
//	@JsonManagedReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	

//	@JsonManagedReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Books book;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	
}
