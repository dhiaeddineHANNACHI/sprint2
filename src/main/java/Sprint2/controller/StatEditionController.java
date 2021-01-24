package Sprint2.controller;

import Sprint2.Services.StatistiqueAuteurServiceImpl;
import Sprint2.Services.StatistiqueEditionServiceImpl;
import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StatEditionController {
    @Autowired
    private StatistiqueEditionServiceImpl ses;

    @GetMapping("/listeEdition")
    public List<Edition> getAllEdition()
    {
        return  (List<Edition>) ses.ListeEdition();
    }
    @GetMapping("/nbrEdition")
    public Long nbrfb()
    {
        return (long) ses.NbrEdition();
    }

}
