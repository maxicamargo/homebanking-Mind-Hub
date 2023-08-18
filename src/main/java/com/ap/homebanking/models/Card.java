package com.ap.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {
    //Atributos o propiedades de la Clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long id;
    private String cardHolder;
    private CardType type;
    private CardColor color;
    private String number;
    private LocalDate thruDate;
    private LocalDate fromDate;
    private int cvv;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientCard_id")
    private Client client;


    //Métodos de la clase
    //Método constructor sin parámetros
    public Card() {
    }

    //Método constructor con parámetros
    public Card(String cardHolder, CardType type, CardColor color, String number, LocalDate thruDate, LocalDate fromDate, int cvv) {
        this.cardHolder = cardHolder;
        this.type = type;
        this.color = color;
        this.number = number;
        this.thruDate = thruDate;
        this.fromDate = fromDate;
        this.cvv = cvv;
    }

    //Métodos accesores getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    //Métodos adicionales

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClientCard() {
        return client;
    }

    public void setClientCard(Client client) {
        this.client = client;
    }
}

