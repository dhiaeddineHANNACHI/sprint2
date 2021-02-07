package Sprint2.services;

import Sprint2.entities.Edition;
import Sprint2.repositories.StatEditionRepository;
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