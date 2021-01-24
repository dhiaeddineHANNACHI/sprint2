package Sprint2.Services;

import Sprint2.entities.Auteur;
import Sprint2.entities.Feedback;

import java.util.List;

public interface IStatistiqueAuteurService {


    List<Auteur> getAllAuthor();
    long nbrAuthor();


}
