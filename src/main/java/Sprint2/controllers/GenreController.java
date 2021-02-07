package Sprint2.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import Sprint2.entities.Genre;

import Sprint2.services.GenreMetier;


@RestController
public class GenreController {

	@Autowired
	private GenreMetier genreMetier;
	
	@GetMapping(value = "/genre/{id}")
	public Genre getbyId(@PathVariable int id)
	{
	return  genreMetier.getGenreById(id);
	}
	
	@RequestMapping(value = "/genre", method = RequestMethod.POST)
	public Genre save(@RequestBody Genre g){
		
		return genreMetier.addGenre(g);
	}
	
	@RequestMapping(value = "/genres/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		 return genreMetier.deleteGenre(id);
	}
	
	@RequestMapping(value = "/AllGenre", method = RequestMethod.GET)
	public List<Genre> getGenres(){
		return genreMetier.listeGenres();
		}
	
	@RequestMapping(value = "/genres/{id}", method = RequestMethod.PUT)
	public Genre save(@PathVariable int id,@RequestBody Genre G){
		G.setId_genre(id);
		return genreMetier.updateGenre(G);
	}
	
	@GetMapping(value = "/nbGenres")
	public Long nbGenres() {
		return genreMetier.nbGenres();
	}
	
	
}
