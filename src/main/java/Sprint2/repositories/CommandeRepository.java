package Sprint2.repositories;

import Sprint2.entities.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande,Integer> {

    List<Commande> findAll();

    Commande findById(int id);


}
