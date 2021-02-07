package Sprint2.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Sprint2.entities.*;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{
	@Query("Select f from Feedback f WHERE f.id_fb = :id")
	Feedback getFeedbackById(@Param("id") int id);
	
	@Query("DELETE FROM Feedback f WHERE f.id_fb = :id")
	Void removeFeedbackById(@Param("id") int id);
}
