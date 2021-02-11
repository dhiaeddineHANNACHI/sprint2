package Sprint2.interfaces;

import Sprint2.entities.Genre;

import java.util.List;

public interface IStatistiqueGenreService {


    List<Genre> ListGenre();
    long NbrGenre();

}
