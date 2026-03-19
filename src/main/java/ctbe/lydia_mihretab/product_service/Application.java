package ctbe.lydia_mihretab.product_service;

import ctbe.lydia_mihretab.product_service.model.Product;
import ctbe.lydia_mihretab.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	CommandLineRunner seedData(ProductRepository repo) {
		return args -> {
			repo.save(new Product("Laptop", 1200.00));
			repo.save(new Product("Monitor", 350.00));
			repo.save(new Product("Keyboard", 86.00));
			System.out.println("TOTAL PRODUCTS IN DB AFTER SEEDING: " + repo.count());
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
