package Sprint2.Services;

import java.util.List;

import Sprint2.Repository.StatFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Feedback;

@Service
public class StatistiqueFeedbackServiceImpl implements IStatistiqueFeedbackService {
	@Autowired
	private StatFeedbackRepository statfeedbackrepo;

	@Override
	public List<Feedback> listeFb() {
		return (List<Feedback>) statfeedbackrepo.findAll();
	}

	@Override
	public List<Feedback> listeFbParId(int id_fb) {
		return statfeedbackrepo.findById(id_fb);
	}

	@Override
	public long NbrFb() {
		return statfeedbackrepo.count();
	}


}