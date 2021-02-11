package Sprint2.interfaces;

import Sprint2.entities.Facture;

import java.util.ArrayList;
import java.util.List;

public interface IServiceStatisticsVente {

    List<String> getStatCommandeByGenreLivre();

    public ArrayList<Facture> getBestSales ();

    ArrayList<String> getStatCommandeByAuteurLivre();

    public String getLivreVendu();

    public String getLivreNonVendu();

    public Double getRevenue();


}
