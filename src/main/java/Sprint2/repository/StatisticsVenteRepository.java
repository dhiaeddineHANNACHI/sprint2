package Sprint2.repository;

import Sprint2.entities.Facture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface StatisticsVenteRepository extends CrudRepository<Facture,Integer> {

    // genre livre commanders
    @Query(value = "SELECT genre.nom_genre FROM ligne_commandes INNER JOIN facture on facture.commande_id=ligne_commandes.id_com INNER JOIN livre_genre on livre_genre.livre_id=ligne_commandes.livre_id INNER JOIN genre on genre.id_genre = livre_genre.id_genre",nativeQuery = true)
    List<String> getStatCommandeByGenreLivre();

    // get best sales
    @Query(value = "SELECT * FROM facture ORDER by montant DESC LIMIT 5",nativeQuery = true)
    public ArrayList<Facture> getBestSales ();

    // les auteur commandes  par livre
     @Query(value ="SELECT auteur.prenom from facture INNER JOIN ligne_commandes on ligne_commandes.id_com=facture.commande_id INNER JOIN livre_auteur on ligne_commandes.livre_id=livre_auteur.livre_id INNER JOIN auteur on auteur.auteur_id=livre_auteur.auteur_id",nativeQuery = true)
    ArrayList<String> getStatCommandeByAuteurLivre();

    // count livre vendu
    @Query(value ="SELECT COUNT(ligne_commandes.livre_id) from ligne_commandes INNER JOIN facture on facture.commande_id=ligne_commandes.id_com",nativeQuery = true)
    public String getLivreVendu();

    // count livre non vendus
    @Query(value ="SELECT count(livre.livre_id) from livre where livre.livre_id not in (SELECT ligne_commandes.livre_id from ligne_commandes INNER JOIN facture on facture.commande_id=ligne_commandes.id_com)",nativeQuery = true)
    public String getLivreNonVendu();

    // Rvenue totale bookStore
    @Query(value ="SELECT SUM(montant) from facture",nativeQuery = true)
    public Double getRevenue();
}
