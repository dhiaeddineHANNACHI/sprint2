package Sprint2.controller;

import Sprint2.Services.StatistiqueAuteurServiceImpl;
import Sprint2.Services.StatistiqueFeedbackServiceImpl;
import Sprint2.Services.StatistiqueLivreServiceImpl;
import Sprint2.entities.Auteur;
import Sprint2.entities.Feedback;
import Sprint2.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StatAuteurController {

    @Autowired
    private StatistiqueAuteurServiceImpl sas;

    @GetMapping("/listeAuteur")
    public List<Auteur> getAllAuthor()
    {
        return  (List<Auteur>) sas.getAllAuthor();
    }
    @GetMapping("/nbrAuthor")
    public Long nbrfb()
    {
        return (long) sas.nbrAuthor();
    }
}
