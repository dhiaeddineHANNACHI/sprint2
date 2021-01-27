package Sprint2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Sprint2.entities.Notification;
import Sprint2.entities.Reclamation;


public interface ReclamationRepository extends CrudRepository<Reclamation, Integer> {

	
	@Query("Select r from Reclamation r WHERE r.reclam_id = :id")
	Reclamation getReclamationById(@Param("id") int id);
	
	@Query("DELETE FROM Reclamation r WHERE r.reclam_id = :id")
	Void removeReclamationById(@Param("id") int id);
}
