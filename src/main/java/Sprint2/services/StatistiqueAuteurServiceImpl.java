package Sprint2.services;

import Sprint2.entities.Auteur;
import Sprint2.interfaces.IStatistiqueAuteurService;
import Sprint2.repositories.StatAuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiqueAuteurServiceImpl implements IStatistiqueAuteurService {

@Autowired
private StatAuteurRepository statAuteurrepo;

    @Override
    public List<Auteur> getAllAuthor() {
        return (List<Auteur>) statAuteurrepo.findAll();
    }

    @Override
    public long nbrAuthor() {
        return (long) statAuteurrepo.count();
    }
}