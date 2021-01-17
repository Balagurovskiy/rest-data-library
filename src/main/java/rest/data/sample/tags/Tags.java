package rest.data.sample.tags;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import rest.data.sample.books.Books;
import rest.data.sample.model.BaseEntity;


@Entity
@Table(name = "tags")
public class Tags extends BaseEntity{

	@JsonBackReference
	@ManyToMany(mappedBy = "tags")
    private Set<Books> books = new HashSet<Books>();
	
	
	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}
}
