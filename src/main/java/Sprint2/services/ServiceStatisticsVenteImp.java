package Sprint2.services;


import Sprint2.entities.Facture;
import Sprint2.repositories.StatisticsVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceStatisticsVenteImp  implements IServiceStatisticsVente{

    @Autowired
    StatisticsVenteRepository statisticsVente;

    @Override
    public List<String> getStatCommandeByGenreLivre() {
        return statisticsVente.getStatCommandeByGenreLivre();
    }

    @Override
    public ArrayList<Facture> getBestSales() {
        return statisticsVente.getBestSales();
    }

    @Override
    public ArrayList<String> getStatCommandeByAuteurLivre() {
        return statisticsVente.getStatCommandeByAuteurLivre();
    }

    @Override
    public String getLivreVendu() {
        return statisticsVente.getLivreVendu();
    }

    @Override
    public String getLivreNonVendu() {
        return statisticsVente.getLivreNonVendu();
    }

    @Override
    public Double getRevenue() {
        return statisticsVente.getRevenue();
    }
}
