package Sprint2.services;

import java.util.List;
import java.util.Map;

import Sprint2.entities.Facture;

public interface IFactureService {

        Map<String, Boolean> AjouterFacture(Facture f);
        Map<String, Boolean> deleteById(int id);
        Map<String, Boolean> UpdateFacture(Facture f);
        List<Facture> afficherFactures();
        Facture getFacture(int id);


}
