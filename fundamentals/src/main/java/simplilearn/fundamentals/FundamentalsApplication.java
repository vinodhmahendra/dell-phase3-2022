package simplilearn.fundamentals;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@SpringBootApplication (short cut) = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
@RestController
public class FundamentalsApplication {

	@Value("${message}")
	private  String message;
	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
		System.out.println("Simplilearn");
	}
	
	@GetMapping(path = "/")
	public String getMessage() {
		return message;
	}

}
