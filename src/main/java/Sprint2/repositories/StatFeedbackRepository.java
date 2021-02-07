package Sprint2.repositories;

import java.util.Collection;
import java.util.List;

import Sprint2.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import Sprint2.entities.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public interface StatFeedbackRepository extends JpaRepository<Feedback,Integer> {

	List<Feedback> findAll();
	List<Feedback> findById(int id_fb);
	long count();




}
