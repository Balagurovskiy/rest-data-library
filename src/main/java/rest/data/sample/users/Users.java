package rest.data.sample.users;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import rest.data.sample.model.BaseEntity;
import rest.data.sample.reviews.Reviews;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {

	@OneToMany(mappedBy = "user")
	@JsonBackReference
	private Set<Reviews> reviews;

	public Set<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	
}
