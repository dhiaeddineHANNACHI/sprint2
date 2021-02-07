package Sprint2.services;

import Sprint2.Repository.StatEditionRepository;
import Sprint2.Repository.StatFeedbackRepository;
import Sprint2.entities.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistiqueEditionServiceImpl implements IStatistiqueEditionService {
    @Autowired
    private StatEditionRepository stateditionrepo;

    @Override
    public List<Edition> ListeEdition() {
        return (List<Edition>) stateditionrepo.findAll() ;
    }

    @Override
    public long NbrEdition() {
        return (long) stateditionrepo.count();
    }
}