package simplilearn.service;

import java.util.List;

import simplilearn.entity.Application;

public interface ApplicationService {
	List<Application> listApplication();
	
	public Application applicationById(Integer id);
	
	public Application save(Application theApplication);

	Application deleteById(int applicationId);

}
