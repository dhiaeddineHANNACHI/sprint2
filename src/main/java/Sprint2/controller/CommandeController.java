package Sprint2.controller;
import Sprint2.entities.Commande;
import Sprint2.exception.ResourceNotFoundException;
import Sprint2.services.CommandeServcieImpl;
import Sprint2.services.ServiceNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class CommandeController
{
    @Autowired
    CommandeServcieImpl commandeServcie;

    @Autowired
    ServiceNLP serviceNLP;

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
    @PostMapping(value = "/commande")
    @ResponseBody
    public Map<String, Boolean> AjouterCommande(@RequestBody Commande c)
    {
        return commandeServcie.AjouterCommande(c);
    }

    @DeleteMapping("/commande/{id}")
    public Map<String,Boolean> DeleteCommande(@PathVariable(value = "id") int id) throws ResourceNotFoundException
    {
        return  commandeServcie.DeleteCommande(id);
    }

    @PostMapping(value = "/nlp/{mseg}")
    private String  getNlpFeedBack(@PathVariable(value = "mseg") String mseg) throws IOException {
        return serviceNLP.NLP(mseg);
    }
}
