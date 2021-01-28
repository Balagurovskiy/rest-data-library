package rest.data.sample.authors;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import rest.data.sample.books.Books;
import rest.data.sample.model.BaseEntity;

@Entity
@Table(name = "authors")
public class Authors extends BaseEntity{
	
	/*
	 * entity relations cause jackson exception 
	 * on POST method - unrecognized json type (error 415)
	 */
//	@JsonIgnore
	@JsonBackReference
	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private Set<Books> books = new HashSet<Books>();

	
	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}
}
