package Sprint2.Services;

import Sprint2.Repository.StatAuteurRepository;
import Sprint2.Repository.StatFeedbackRepository;
import Sprint2.entities.Auteur;
import Sprint2.entities.Feedback;
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