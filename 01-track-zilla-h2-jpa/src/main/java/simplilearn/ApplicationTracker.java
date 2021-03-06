package simplilearn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import simplilearn.entity.Application;
import simplilearn.repository.ApplicationRepository;

@SpringBootApplication
public class ApplicationTracker {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTracker.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo (ApplicationRepository repository) {
//		return (args) -> {
//			repository.save(new Application("Trackzilla", "vinodh", "Application for tracking bugs."));
//			repository.save(new Application("Expenses", "vinodh", "Application to track  expense reports."));
//			repository.save(new Application("Notifications", "vinodh", "Application to send alerts and notifications to users."));
//		
//			for ( Application application : repository.findAll()) {
//				System.out.println("The application is: "+ application.toString());
//			}
//		};
//	}

}
