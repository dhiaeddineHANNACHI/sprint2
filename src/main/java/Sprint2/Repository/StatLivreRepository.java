package Sprint2.Repository;

import java.util.Collection;
import java.util.List;

import Sprint2.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import Sprint2.entities.Livre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("StatLivreRepository")
public interface StatLivreRepository extends JpaRepository<Livre,Integer> {

	List<Livre> findAll();
	List<Livre> findById(int livre_id);
	long count();
	@Query(value = "SELECT count(*) FROM Livre l WHERE l.edition_id= ?1 " , nativeQuery = true)
	Long  CountBookByEdition(int edition_id);
	@Query(value = "SELECT * FROM Livre l,livre_genre lg , genre g WHERE l.livre_id=lg.livre_id and g.nom_genre= ?1 " , nativeQuery = true)
	List<Livre> ListBookByGender(String nom_genre);
	@Query(value = "SELECT count(*) FROM Livre l,livre_genre lg , genre g WHERE l.livre_id=lg.livre_id and g.nom_genre= ?1 " , nativeQuery = true)
	Long  CountBookByGender(String nom_genre);
}
