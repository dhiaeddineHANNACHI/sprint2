package Sprint2.controllers;

import Sprint2.entities.Facture;
import Sprint2.exception.ResourceNotFoundException;
import Sprint2.services.FactureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class FactureController 
{
	@Autowired
    private  FactureServiceImpl factureService ;

	@GetMapping(value = "/factures")
	public List<Facture> getAllFactures  ()  throws ResourceNotFoundException
	{
	return  factureService.afficherFactures();
	}

	@GetMapping("/facture/{id}")
	public Facture getUsersById(@PathVariable(value = "id") int Id) throws ResourceNotFoundException
	{
		return  factureService.getFacture(Id);
	}

	@PostMapping(value = "/createFacture")
	public Map<String, Boolean> createFacture(@Valid @RequestBody Facture facture)  throws ResourceNotFoundException
	{
	  return factureService.AjouterFacture(facture);
	}

	@PutMapping(value = "/updateFacture")
	public Map<String, Boolean> UpdateFacture(@RequestBody Facture facture)  throws ResourceNotFoundException
	{
		return factureService.UpdateFacture(facture);
	}

	@DeleteMapping("/deletefacture/{id}")
	public Map<String, Boolean> DeletteUsersById(@PathVariable(value = "id") int id)  throws ResourceNotFoundException
	{
		return  factureService.deleteById(id);
	}
}