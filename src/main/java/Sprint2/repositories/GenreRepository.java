package Sprint2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import Sprint2.entities.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
	@Query("Select g from Genre g WHERE g.id = :id")
	public Genre getGenreById(@Param("id") int id);
	
	
}
