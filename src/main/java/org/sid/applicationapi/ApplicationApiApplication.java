package org.sid.applicationapi;

import org.sid.applicationapi.model.Product;
import org.sid.applicationapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class ApplicationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationApiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);

            productRepository.save(new Product(null, "Printer", 400, 80));
            productRepository.save(new Product(null, "Computer", 2044, 20));
            productRepository.save(new Product(null, "Phone", 1400, 100));
            productRepository.save(new Product(null, "Keyboard", 300, 200));
            productRepository.save(new Product(null, "Mouse", 150, 45));

        };
    }

}
