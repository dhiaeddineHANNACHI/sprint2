package Sprint2.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import Sprint2.entities.Genre;
import Sprint2.entities.Livre;
import Sprint2.interfaces.LivreMetier;

@RestController
public class LivreController {
	
	@Autowired
	private LivreMetier livreMetier;
	
	@PostMapping(value = "/livre")
	public Livre save(@RequestBody Livre l){
		
		return livreMetier.addLivre(l);
	}
	@RequestMapping(value = "/AllLivre", method = RequestMethod.GET)
	public List<Livre> getLivres(){
		return livreMetier.listeLivres();
		}
	@GetMapping(value = "/livre/{id}")
	public Livre getbyId(@PathVariable int id)
	{
	return livreMetier.getLivreById(id);
	}
	
	@RequestMapping(value = "/livres/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		 return livreMetier.deleteLivre(id);
	}
	
	@PutMapping(value = "/livres/{id}")
	public Livre update(@PathVariable int id,@RequestBody Livre l){
		l.setLivre_id(id);
		return livreMetier.updateLivre(l);
	}
	
	@GetMapping(value = "/genreLivre/{id}")
	public Set<Genre> getGenrebyIdLivre(@PathVariable int id)
	{
	return livreMetier.getGenresByLivre(id);
	}
	
	@GetMapping(value = "/auteursLivre/{id}")
	public Set<Auteur> getAuteurbyIdLivre(@PathVariable int id)
	{
	return livreMetier.getAuteursByLivre(id);
	}
	
	@GetMapping(value = "/editionLivre/{id}")
	public Edition getEditionbyIdLivre(@PathVariable int id)
	{
	return livreMetier.getEditionsByLivre(id);
	}
	
	@GetMapping(value = "/nbLivres")
	public int nbLivres() {
		return livreMetier.nbLivres();
	}
	

}
