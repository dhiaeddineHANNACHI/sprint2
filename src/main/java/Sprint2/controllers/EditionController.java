package Sprint2.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Sprint2.entities.Edition;
import Sprint2.interfaces.EditionMetier;




@RestController
public class EditionController {
	
	@Autowired
	private EditionMetier editionMetier;
	
	
	
	@GetMapping(value = "/edition/{id}")
	public Edition getbyId(@PathVariable int id)
	{
	return  editionMetier.getEditionById(id);
	}
	
	@RequestMapping(value = "/edition", method = RequestMethod.POST)
	public Edition save(@RequestBody Edition e){
		
		return editionMetier.addEdition(e);
	}
	
	@RequestMapping(value = "/editions/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		 return editionMetier.deleteEdition(id);
	}
	
	@RequestMapping(value = "/AllEdition", method = RequestMethod.GET)
	public List<Edition> getEditions(){
		return editionMetier.listeEditions();
		}
	
	@RequestMapping(value = "/editions/{id}", method = RequestMethod.PUT)
	public Edition save(@PathVariable int id,@RequestBody Edition E){
		E.setId_editeur(id);
		return editionMetier.updateEdition(E);
	}
	@GetMapping(value = "/nbEditions")
	public Long nbEditions() {
		return editionMetier.nbEditions();
	}
	
	
	
}
