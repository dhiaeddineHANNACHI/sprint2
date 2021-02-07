package Sprint2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Sprint2.entities.Edition;


public interface EditionRepository extends CrudRepository<Edition, Integer>{
	@Query("Select e from Edition e WHERE e.id = :id")
	public Edition getEditionById(@Param("id") int id);
	
	
}
