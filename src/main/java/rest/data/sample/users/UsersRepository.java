package rest.data.sample.users;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long>{
	Iterable<Users> findAll();
	Iterable<Users> findByNameContaining(String str);
}
