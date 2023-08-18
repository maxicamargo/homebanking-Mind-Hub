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


	//Agregar al CommandLineRunner , LoanRepository loanRepository, ClientLoanRepository clientLoanRepository
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository,ClientLoanRepository clientLoanRepository,CardRepository cardRepository){
		return (args -> {

		//Creacion de cuentas 1 y 2
		Account account1 = new Account("VIN001", LocalDate.now(), 5000);
		Account account2 = new Account("VIN002",LocalDate.now().plusDays(1),7500);

		//Creacion de cliente 1
		Client client1 = new Client("Melba","Morel","melba@mindhub.com");

		//Guardamos el cliente 1
		clientRepository.save(client1); //Guardo la persona y le genero una clave primaria(id)

		//Agregamos al cliente 1 las cuentas 1 y 2
		client1.addAccount(account1);
		client1.addAccount(account2);

		//Guardamos las cuentas asignadas al cliente 1
		accountRepository.save(account1);
		accountRepository.save(account2);

		//Creacion de cuentas 3 y 4
		Account account3 = new Account("VIN003", LocalDate.now(), 500);
		Account account4 = new Account("VIN004",LocalDate.now().plusDays(2),2500);

		//Creacion del cliente 2
		Client client2 = new Client("Maximiliano","Camargo","maxi.camargo@gmail.com");

		//Guardamos el cliente 2
		clientRepository.save(client2);

		//Agregamos al cliente 2 las cuentas 3 y 4
		client2.addAccount(account3);
		client2.addAccount(account4);

		//Guardamos las cuentas asignadas al cliente 2
		accountRepository.save(account3);
		accountRepository.save(account4);

		//Creamos 8 transacciones bancarias distintas
		Transaction transaction1 = new Transaction(TransactionType.CREDIT,800000,"Ampliacion Casa", LocalDateTime.now());
		Transaction transaction2 = new Transaction(TransactionType.CREDIT,50000,"Reparacion Auto",LocalDateTime.now());
		Transaction transaction3 = new Transaction(TransactionType.DEBIT,-55000,"Pago Tarjeta",LocalDateTime.now());
		Transaction transaction4 = new Transaction(TransactionType.DEBIT,-17000, "Personal-FLow",LocalDateTime.now());
		Transaction transaction5 = new Transaction(TransactionType.CREDIT,120000,"Reparacion Casa",LocalDateTime.now());
		Transaction transaction6 = new Transaction(TransactionType.DEBIT,-8000,"Pago peaje",LocalDateTime.now());
		Transaction transaction7 = new Transaction(TransactionType.DEBIT,-12000,"Compras supermercado",LocalDateTime.now());
		Transaction transaction8 = new Transaction(TransactionType.CREDIT,32000,"Vacaciones",LocalDateTime.now());

		//Asignamos las transacciones 1 y 3 a la cuenta 1 del cliente 1
		account1.addTransaction(transaction1);
		account1.addTransaction(transaction3);

		//Asignamos las transacciones 2 y 8 a la cuenta 2 del cliente 1
		account2.addTransaction(transaction2);
		account2.addTransaction(transaction8);

		//Asignamos las transacciones 4 y 6 a la cuenta 3 del cliente 2
		account3.addTransaction(transaction4);
		account3.addTransaction(transaction6);

		//Asignamos las transacciones 5 y 7 a la cuenta 4 del cliente 2
		account4.addTransaction(transaction5);
		account4.addTransaction(transaction7);

		//Guardamos las transacciones asignadas a los clientes
		transactionRepository.save(transaction1);
		transactionRepository.save(transaction2);
		transactionRepository.save(transaction3);
		transactionRepository.save(transaction4);
		transactionRepository.save(transaction5);
		transactionRepository.save(transaction6);
		transactionRepository.save(transaction7);
		transactionRepository.save(transaction8);


		//Creamos los 3 tipos de préstamos disponibles
		Loan loan1 = new Loan("Hipotecario",500000, List.of(12,24,36,48,60));
		Loan loan2 = new Loan("Personal",100000,List.of(6,12,24));
		Loan loan3 = new Loan("Automotriz",300000,List.of(6,12,24,36));

		//Guardamos los 3 tipos de préstamos generados
		loanRepository.save(loan1);
		loanRepository.save(loan2);
		loanRepository.save(loan3);

		//Creamos los prestamos y los asociamos a los clientes
		ClientLoan clientLoan1 = new ClientLoan(400000,60,client1,loan1);
		ClientLoan clientLoan2 = new ClientLoan(50000,12,client1,loan2);

		ClientLoan clientLoan3 = new ClientLoan(100000,24,client2,loan2);
		ClientLoan clientLoan4 = new ClientLoan(200000,36,client2,loan3);

		//Guardamos los prestamos asignados a los clientes
		clientLoanRepository.save(clientLoan1);
		clientLoanRepository.save(clientLoan2);
		clientLoanRepository.save(clientLoan3);
		clientLoanRepository.save(clientLoan4);


		//Creamos las tarjetas
		Card card1 = new Card(client1.getFirstName()+" "+client1.getLastName(),CardType.DEBIT,CardColor.GOLD,"3446-5573-3568-5678",LocalDate.now(),LocalDate.now().plusYears(5),314);
		Card card2 = new Card(client1.getFirstName()+" "+client1.getLastName(),CardType.CREDIT,CardColor.TITANIUM,"4566-3489-4896-5678",LocalDate.now(),LocalDate.now().plusYears(5),829);

		Card card3 = new Card(client2.getFirstName()+" "+client2.getLastName(),CardType.CREDIT,CardColor.SILVER,"2894-6598-3568-3489",LocalDate.now(),LocalDate.now().plusYears(3),642);




		//Asignamos las tarjetas 1 y 2 al cliente 1
		client1.addCard(card1);
		client1.addCard(card2);

		//Asignamos la tarjeta 3 al cliente 2
		client2.addCard(card3);

		//Guardamos las tarjetas creadas
		cardRepository.save(card1);
		cardRepository.save(card2);
		cardRepository.save(card3);


		});
	}

}
