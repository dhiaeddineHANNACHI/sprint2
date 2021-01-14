package Sprint2.controller;

import Sprint2.entities.Commande;
import Sprint2.entities.Facture;
import Sprint2.exception.ResourceNotFoundException;
import Sprint2.services.CommandeServcieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeController {

    @Autowired
    CommandeServcieImpl commandeServcie;

    @GetMapping(value = "/commandes")
    public List<Commande> getAllCommandes  ()  throws ResourceNotFoundException
    {
        return  commandeServcie.listerCommandes();
    }

    @GetMapping("/commande/{id}")
    public Commande getUsersById(@PathVariable(value = "id") int Id) throws ResourceNotFoundException
    {
       return commandeServcie.getByCommande(Id);
    }

}
