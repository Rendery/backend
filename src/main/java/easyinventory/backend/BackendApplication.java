package easyinventory.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		String url = "http://localhost:8080/swagger-ui.html";
		System.out.println("\n• Swagger UI is available at » " + url);
	}

}
