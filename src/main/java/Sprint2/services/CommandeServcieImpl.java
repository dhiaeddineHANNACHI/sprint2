package Sprint2.services;
import Sprint2.entities.Commande;
import Sprint2.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommandeServcieImpl implements  ICommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Map<String, Boolean> AjouterCommande(Commande c)
    {
        commandeRepository.save(c);
        Map<String, Boolean> response = new HashMap<>();
        response.put("AjouterCommande", Boolean.TRUE);
        return response;
    }
    @Override
    public List<Commande> listerCommandes()
    {
        return commandeRepository.findAll();
    }
    @Override
    public Map<String, Boolean> updateCommande(Commande c)
    {
        commandeRepository.save(c);
        Map<String, Boolean> response = new HashMap<>();
        response.put("updateCommande", Boolean.TRUE);
        return response;
    }

    @Override
    public Map<String, Boolean> DeleteCommande(int id)
    {
        commandeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DeleteCommande", Boolean.TRUE);
        return response;
    }
    @Override
    public Commande getByCommande(int id) {
        return  commandeRepository.findById(id);
    }
}
