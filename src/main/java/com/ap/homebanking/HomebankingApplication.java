package com.ap.homebanking;

import com.ap.homebanking.models.Account;
import com.ap.homebanking.models.Client;
import com.ap.homebanking.repositories.AccountRepository;
import com.ap.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return (args -> {

		Account account1 = new Account("VIN001", LocalDate.now(), 5000);
		Account account2 = new Account("VIN002",LocalDate.now().plusDays(1),7500);

		Client client1 = new Client("Melba","Morel","melba@mindhub.com");

		clientRepository.save(client1); //Guardo la persona y le genero una clave primaria(id)

		client1.addAccount(account1);
		client1.addAccount(account2);

		accountRepository.save(account1);
		accountRepository.save(account2);


		Account account3 = new Account("VIN003", LocalDate.now(), 500);
		Account account4 = new Account("VIN004",LocalDate.now().plusDays(2),2500);

		Client client2 = new Client("Maximiliano","Camargo","maxi.camargo@gmail.com");

		clientRepository.save(client2);

		client2.addAccount(account3);
		client2.addAccount(account4);

		accountRepository.save(account3);
		accountRepository.save(account4);

		});
	}

}
