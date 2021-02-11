package Sprint2.repositories;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Sprint2.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "SELECT * FROM users u INNER JOIN user_roles ur ON (u.id = ur.user_id) WHERE ur.role_id=2", nativeQuery = true)
	Collection <User> getGerants();
}
