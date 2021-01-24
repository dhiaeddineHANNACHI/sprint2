package Sprint2.Services;

import Sprint2.Repository.StatGenreRepository;
import Sprint2.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiqueGenreServiceImpl implements IStatistiqueGenreService {
@Autowired
private StatGenreRepository sgr;

    @Override
    public List<Genre> ListGenre() {
        return (List<Genre>) sgr.findAll();
    }

    @Override
    public long NbrGenre() {
        return (long) sgr.count();
    }
}