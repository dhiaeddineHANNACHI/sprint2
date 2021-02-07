package Sprint2.controllers;


import Sprint2.entities.Auteur;
import Sprint2.services.StatistiqueAuteurServiceImpl;
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
    @GetMapping("/nbrAuteur")
    public Long nbrfb()
    {
        return (long) sas.nbrAuthor();
    }
}
