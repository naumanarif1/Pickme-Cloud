package so.pickme.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.data.neo4j.repository.SchemaIndexRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import so.pickme.replica.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,
		SchemaIndexRepository<User>, RelationshipOperationsRepository<User> {

	/**@Repository need's to be tested
	 * @return the complete list of persons stored in the repository.
	 */
	@Query("Match (user:User) Where user.username = {0} return user")
	User findByUsername(String username);

	/**
	 * @param maxResult
	 *            Max number of persons.
	 * @return a limited list of persons.
	 */
	// @Query("Match (user:User) return user")
	public List<User> findAll();

}
