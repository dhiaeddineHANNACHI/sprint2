package Sprint2.services;

import Sprint2.entities.Genre;

import java.util.List;

public interface IStatistiqueGenreService {


    List<Genre> ListGenre();
    long NbrGenre();

}
