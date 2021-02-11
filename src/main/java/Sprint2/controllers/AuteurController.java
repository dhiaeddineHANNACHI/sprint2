package Sprint2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Sprint2.entities.Auteur;
import Sprint2.interfaces.AuteurMetier;


@RestController
public class AuteurController {

	@Autowired
	private AuteurMetier auteurMetier;
	
	@GetMapping(value = "/auteur/{id}")
	public Auteur getbyId(@PathVariable int id)
	{
	return  auteurMetier.getAuteurById(id);
	}
	
	@RequestMapping(value = "/auteur", method = RequestMethod.POST)
	public Auteur save(@RequestBody Auteur a){
		
		return auteurMetier.addAuteur(a);
	}
	
	@RequestMapping(value = "/auteurs/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		 return auteurMetier.deleteAuteur(id);
	}
	
	@RequestMapping(value = "/AllAuteur", method = RequestMethod.GET)
	public List<Auteur> getAuteurs(){
		return auteurMetier.listeAuteurs();
		}
	
	@RequestMapping(value = "/auteurs/{id}", method = RequestMethod.PUT)
	public Auteur save(@PathVariable int id,@RequestBody Auteur A){
		A.setAuteur_id(id);
		return auteurMetier.updateAuteur(A);
	}
	@GetMapping(value = "/nbAuteurs")
	public Long nbAuteurs() {
		return auteurMetier.nbAuteurs();
	}
	
	
}
