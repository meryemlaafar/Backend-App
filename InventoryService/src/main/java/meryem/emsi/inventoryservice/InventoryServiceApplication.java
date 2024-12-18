package meryem.emsi.inventoryservice;

import meryem.emsi.inventoryservice.Repository.ProductRepository;
import meryem.emsi.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Product.class);
            productRepository.save(Product.builder()
                   // .id(UUID.randomUUID().Long)
                    .name("Computer")
                    .price(3200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                  //  .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(1299)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                   // .id(UUID.randomUUID().toString())
                    .name("Smart Phone")
                    .price(5400)
                    .quantity(8)
                    .build());
            productRepository.save(Product.builder()
                    // .id(UUID.randomUUID().toString())
                    .name("Smart Watch")
                    .price(5400)
                    .quantity(8)
                    .build());
            productRepository.save(Product.builder()
                    // .id(UUID.randomUUID().toString())
                    .name("Clavier")
                    .price(5400)
                    .quantity(8)
                    .build());
            productRepository.save(Product.builder()
                    // .id(UUID.randomUUID().toString())
                    .name("Unité Centrale")
                    .price(5400)
                    .quantity(8)
                    .build());

            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
