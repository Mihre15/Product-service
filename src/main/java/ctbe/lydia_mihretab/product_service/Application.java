package ctbe.lydia_mihretab.product_service;

import ctbe.lydia_mihretab.product_service.model.Product;
import ctbe.lydia_mihretab.product_service.repository.ProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Product Service API",
		version = "1.0.0",
		description = "RESTful Product Catalogue — Lab 2"
))
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
