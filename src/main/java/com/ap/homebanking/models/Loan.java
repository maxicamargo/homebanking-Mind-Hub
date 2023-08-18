package com.ap.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Loan {
    //Atributos o propiedades de la Clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String name;
    private double maxAmount;

    @ElementCollection
    @Column(name = "payment")
    private List<Integer> payments = new ArrayList<>();

    @OneToMany(mappedBy = "loan",fetch = FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();


    //Métodos de la clase
    //Método constructor sin parámetros
    public Loan() {
    }


    //Método constructor con parámetros
    public Loan(String name, double maxAmount, List<Integer> payments) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.payments = payments;
    }

    //Métodos accesores getters y setters


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }

    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void setClientLoans(Set<ClientLoan> clientLoans) {
        this.clientLoans = clientLoans;
    }

    public void addLoan(ClientLoan clientLoan){
        clientLoan.setLoan(this);
        clientLoans.add(clientLoan);
    }

    public List<Client> getClients(){
        return clientLoans.stream().map(clients -> clients.getClient()).collect(toList());
    }
}

