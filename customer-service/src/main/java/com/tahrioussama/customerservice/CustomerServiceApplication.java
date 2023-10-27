package com.tahrioussama.customerservice;

import com.tahrioussama.customerservice.entities.Customer;
import com.tahrioussama.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Oussama").email("oussama@gmail.com").build(),
                            Customer.builder().name("Marouane").email("marouane@gmail.com").build(),
                            Customer.builder().name("Tahri").email("tahri@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }

}
