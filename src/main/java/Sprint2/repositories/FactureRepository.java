package Sprint2.repositories;


import Sprint2.entities.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Integer>
{
	 List<Facture> findAll();
	 Facture findById(int id);
}
