package Sprint2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Sprint2.entities.Auteur;



public interface AuteurRepository extends CrudRepository <Auteur , Integer>{
	
	@Query("Select a from Auteur a WHERE a.id = :id")
	public Auteur getAuteurById(@Param("id") int id);
	
	
}
