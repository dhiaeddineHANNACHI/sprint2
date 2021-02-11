package Sprint2.interfaces;

import Sprint2.entities.Facture;

import java.util.List;
import java.util.Map;

public interface IFactureService {

        Map<String, Boolean> AjouterFacture(Facture f);
        Map<String, Boolean> deleteById(int id);
        Map<String, Boolean> UpdateFacture(Facture f);
        List<Facture> afficherFactures();
        Facture getFacture(int id);


}
