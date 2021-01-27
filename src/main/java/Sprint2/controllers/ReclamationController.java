package Sprint2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;


import Sprint2.entities.Reclamation;
import Sprint2.services.ReclamationService;
import Sprint2.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/manageReclamation")
public class ReclamationController {
	@Autowired
	ReclamationService recService;
	
	@GetMapping(value = "/reclamations")
	public List<Reclamation> getAllReclamations  () throws ResourceNotFoundException
	{
	    return  recService.retrieveAllReclamations();
	}
	
	@GetMapping("/reclamation/{id}")
	public Reclamation getReclamationById(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return  recService.retrieveReclamation(id);
	}

	@PostMapping(value = "/newReclamation")
	public Reclamation newReclamation(@Valid @RequestBody Reclamation reclamation)  throws ResourceNotFoundException
	{
		return recService.addReclamation(reclamation);
	}

	@PutMapping(value = "/updateReclamation")
	public Reclamation UpdateReclamation(@RequestBody Reclamation reclamation)  throws ResourceNotFoundException {
		 return recService.updateReclamation(reclamation);
	}

	@DeleteMapping("/deleteReclamation/{id}")
	public void deleteReclamationById(@PathVariable(value = "id") int id)  throws ResourceNotFoundException
	{
		recService.deleteReclamation(id);
	}
	
	@GetMapping("/gerant/{id}/reclamations")
	public Set<Reclamation> getReclamationByIdGerant(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return  recService.getGerantReclams(id);
	}
	@GetMapping("/commande/{id}/reclamations")
	public Set<Reclamation> getReclamationByIdCommande(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return  recService.getCommandeReclams(id);
	}
}
