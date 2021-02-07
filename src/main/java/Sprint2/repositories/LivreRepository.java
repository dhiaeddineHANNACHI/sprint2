package Sprint2.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



import Sprint2.entities.Livre;



public interface LivreRepository extends CrudRepository <Livre , Integer> {
	@Query("Select l from Livre l WHERE l.id = :id")
	public Livre getLivreById(@Param("id") int id);
	
	@Query(value="SELECT genre_id FROM livre_genre  WHERE livre_id = ?1" , nativeQuery = true)
	public List<Integer> getLivreGenreList(int livre_id);
	
	@Query("SELECT count(*) FROM Livre")
	public int NbLivres();
	
	
	
}
