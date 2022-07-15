package simplilearn.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import simplilearn.entity.Application;
import simplilearn.service.ApplicationService;

@RestController
public class TrazkZillaResource {

	private ApplicationService applicationService;

	@Autowired
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/applications")
	public ResponseEntity<List<Application>> getAllApplications() {
		List<Application> list = applicationService.listApplication();
		return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
	}

	// HTTP Method : GET
	// URI : localhost:8080/applications/1 --- > placeholder to store a value '1' -
//	--- uri template ---- > {applicationId}
	@GetMapping("/applications/{applicationId}")
	public Application getApplication(@PathVariable int applicationId) {
		Application application = applicationService.applicationById(applicationId);
		return application;
	}

	// HTTP Method : POST ---- > @PostMapping
	// URI : localhost:8080/applications
	// Request Body ---> { json object } --- > @RequestBody

	// HTTP Response
	// Status Code 201
	// response header = location
	@PostMapping("/applications")
	public ResponseEntity createApplication(@RequestBody Application theApplication) {
		Application loadedApplication = applicationService.save(theApplication);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(loadedApplication.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	//HTTP Method : PUT
	//URI : localhost:8080/applications/6
	
	//HTTP Response , Status Code : 204
	
	@PutMapping("/applications/{applicationId}")
	public ResponseEntity<Application> updateApplication(@RequestBody Application theApplication,@PathVariable int applicationId){
		Application updatedApplication = applicationService.save(theApplication);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/applications/{applicationId}")
	public ResponseEntity deleteApplication(@PathVariable int applicationId) {
		Application theApplication = applicationService.deleteById(applicationId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/applications" , method = RequestMethod.OPTIONS)
	ResponseEntity<?> collectionOptions () {
		return ResponseEntity.ok().allow(HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE).build();
	}
}