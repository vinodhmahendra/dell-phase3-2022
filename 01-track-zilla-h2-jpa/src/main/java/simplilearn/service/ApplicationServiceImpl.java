package simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplilearn.entity.Application;
import simplilearn.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> listApplication() {
		return (List<Application>) applicationRepository.findAll();
	}

	@Override
	public Application applicationById(Integer id) {
		return applicationRepository.findById(id).get();
	}

	@Override
	public Application save(Application theApplication) {
		Application savedApplication = applicationRepository.save(theApplication);
		return savedApplication;
	}

	@Override
	public Application deleteById(int applicationId) {
		 applicationRepository.deleteById(applicationId);
		 return null;
	}

}
