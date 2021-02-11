package Sprint2.interfaces;


import java.util.List;
import java.util.Set;

import Sprint2.entities.Genre;
import Sprint2.entities.Livre;

public interface GenreMetier {

	public Genre addGenre(Genre g);
	public List<Genre> listeGenres();
	public boolean deleteGenre(int id);
	public Genre updateGenre(Genre g);
	public Genre getGenreById(int id);
	public Long nbGenres();
	
}
