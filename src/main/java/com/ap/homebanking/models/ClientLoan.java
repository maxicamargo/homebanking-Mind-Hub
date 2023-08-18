package com.ap.homebanking.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ClientLoan {
    //Atributos o propiedades de la Clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private double amount;
    private int payments;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    //Métodos de la clase
    //Método constructor sin parámetros
    public ClientLoan() {
    }

    //Método constructor con parámetros
    public ClientLoan(double amount, int payments, Client client, Loan loan) {
        this.amount = amount;
        this.payments = payments;
        this.client = client;
        this.loan = loan;

    }

    //Métodos accesores getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @JsonIgnore
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    //Métodos adicionales
    public String toString(){
        return client + " "+ loan+" "+amount+" "+payments;
    }



}
