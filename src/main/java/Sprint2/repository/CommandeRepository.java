package Sprint2.repository;

import Sprint2.entities.Commande;
import Sprint2.entities.Facture;
import org.hibernate.sql.Delete;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande,Integer> {

    List<Commande> findAll();

    Commande findById(int id);


}
