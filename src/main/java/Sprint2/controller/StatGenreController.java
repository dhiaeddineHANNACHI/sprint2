package Sprint2.controller;

import Sprint2.Services.StatistiqueAuteurServiceImpl;
import Sprint2.Services.StatistiqueGenreServiceImpl;
import Sprint2.entities.Auteur;
import Sprint2.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StatGenreController {
    @Autowired
    private StatistiqueGenreServiceImpl sgs;

    @GetMapping("/listeGenre")
    public List<Genre> getAllGender()
    {
        return  (List<Genre>) sgs.ListGenre();
    }
    @GetMapping("/nbrGenre")
    public Long NbrGender()
    {
        return (long) sgs.NbrGenre();
    }

}
