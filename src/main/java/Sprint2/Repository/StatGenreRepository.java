package Sprint2.Repository;

import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import Sprint2.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatGenreRepository extends JpaRepository<Genre,Integer> {

    List<Genre> findAll();
    long count();

}
