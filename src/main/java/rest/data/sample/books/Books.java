package rest.data.sample.books;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import rest.data.sample.authors.Authors;
import rest.data.sample.model.BaseEntity;
import rest.data.sample.reviews.Reviews;
import rest.data.sample.tags.Tags;


@Entity
@Table(name = "books")
public class Books extends BaseEntity{
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "author_book", 
    		joinColumns = { @JoinColumn(name = "book_id") }, 
    		inverseJoinColumns = { @JoinColumn(name = "author_id") }
    		)
    private Set<Authors> authors = new HashSet<Authors>();
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "book_tag", 
    		joinColumns = { @JoinColumn(name = "book_id") }, 
    		inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    		)
    private Set<Tags> tags = new HashSet<Tags>();
	

	@JsonBackReference
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private List<Reviews> reviews;
	
    @Column(name = "release_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
    private Date releaseDate;
    
	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
