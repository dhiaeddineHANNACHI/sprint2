package Sprint2.Repository;

import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatEditionRepository extends JpaRepository<Edition,Integer> {

    List<Edition> findAll();
    long count();

}
