package Sprint2.repositories;

import Sprint2.entities.Auteur;
import Sprint2.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatAuteurRepository extends JpaRepository<Auteur,Integer> {

    List<Auteur> findAll();
    long count();

}
