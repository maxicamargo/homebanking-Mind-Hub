package com.ap.homebanking;

import com.ap.homebanking.models.*;
import com.ap.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository){
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


		Transaction transaction1 = new Transaction(TransactionType.CREDIT,800000,"Credito Hipotecario", LocalDateTime.now());
		Transaction transaction2 = new Transaction(TransactionType.CREDIT,50000,"Reparacion Auto",LocalDateTime.now());
		Transaction transaction3 = new Transaction(TransactionType.DEBIT,55000,"Pago Tarjeta",LocalDateTime.now());
		Transaction transaction4 = new Transaction(TransactionType.DEBIT,17000, "Personal-FLow",LocalDateTime.now());
		Transaction transaction5 = new Transaction(TransactionType.CREDIT,120000,"Reparacion Casa",LocalDateTime.now());
		Transaction transaction6 = new Transaction(TransactionType.DEBIT,8000,"Pago peaje",LocalDateTime.now());
		Transaction transaction7 = new Transaction(TransactionType.DEBIT,12000,"Comprar supermercado",LocalDateTime.now());
		Transaction transaction8 = new Transaction(TransactionType.CREDIT,32000,"Vacaciones",LocalDateTime.now());

		account1.addTransaction(transaction1);
		account1.addTransaction(transaction3);

		account2.addTransaction(transaction2);
		account2.addTransaction(transaction8);

		account3.addTransaction(transaction4);
		account3.addTransaction(transaction6);

		account4.addTransaction(transaction5);
		account4.addTransaction(transaction7);


		transactionRepository.save(transaction1);
		transactionRepository.save(transaction2);
		transactionRepository.save(transaction3);
		transactionRepository.save(transaction4);
		transactionRepository.save(transaction5);
		transactionRepository.save(transaction6);
		transactionRepository.save(transaction7);
		transactionRepository.save(transaction8);

		Loan loan1 = new Loan("Hipotecario",500000, List.of(12,24,36,48,60));
		Loan loan2 = new Loan("Personal",100000,List.of(6,12,24));
		Loan loan3 = new Loan("Automotriz",300000,List.of(6,12,24,36));

		loanRepository.save(loan1);
		loanRepository.save(loan2);
		loanRepository.save(loan3);


		ClientLoan clientLoan1 = new ClientLoan(400000,60,client1,loan1);
		ClientLoan clientLoan2 = new ClientLoan(50000,12,client1,loan2);

		ClientLoan clientLoan3 = new ClientLoan(100000,24,client2,loan2);
		ClientLoan clientLoan4 = new ClientLoan(200000,36,client2,loan3);

		clientLoanRepository.save(clientLoan1);
		clientLoanRepository.save(clientLoan2);
		clientLoanRepository.save(clientLoan3);
		clientLoanRepository.save(clientLoan4);



		});
	}

}
