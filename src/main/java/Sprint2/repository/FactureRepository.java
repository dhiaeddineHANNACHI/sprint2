package Sprint2.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Sprint2.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Integer>
{
	 List<Facture> findAll();
	 Facture findById(int id);
}
