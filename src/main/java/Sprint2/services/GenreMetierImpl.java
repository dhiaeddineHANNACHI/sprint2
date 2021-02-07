package Sprint2.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Sprint2.entities.Genre;
import Sprint2.entities.Livre;
import Sprint2.repositories.GenreRepository;

@Service
public class GenreMetierImpl implements GenreMetier{

	@Autowired
	private GenreRepository genreRepository;
	@Override
	public Genre addGenre(Genre g) {
		return genreRepository.save(g);
	}

	@Override
	public List<Genre> listeGenres() {
		return (List<Genre>) genreRepository.findAll();
	}

	@Override
	public boolean deleteGenre(int id) {
		genreRepository.deleteById(id);
		return true;
	}

	@Override
	public Genre updateGenre(Genre g) {
		return genreRepository.save(g);
	}

	@Override
	public Genre getGenreById(int id) {
		return genreRepository.getGenreById(id);
	}

	@Override
	public Long nbGenres() {
		return genreRepository.count();
	}

	

}
