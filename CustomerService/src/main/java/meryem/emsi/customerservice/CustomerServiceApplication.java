package meryem.emsi.customerservice;

import meryem.emsi.customerservice.Repository.CustomerRepository;
import meryem.emsi.customerservice.config.CustomerConfigParams;
import meryem.emsi.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args ->{
			//
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("Meryem").email("meryem@gmail.com").build(),
							Customer.builder().name("Hajar").email("hajar@gmail.com").build(),
							Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
							Customer.builder().name("khalil").email("khalil@gmail.com").build(),
							Customer.builder().name("Zineb").email("zineb@gmail.com").build()
					)
			);
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
