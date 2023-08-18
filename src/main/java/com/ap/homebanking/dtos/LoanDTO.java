package com.ap.homebanking.dtos;

import com.ap.homebanking.models.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanDTO {
    private long id;
    private String name;
    private double amount;
    private List<Integer> payments = new ArrayList<>();

    public LoanDTO() {
    }

    public LoanDTO(Loan loan){
        this.id = loan.getId();
        this.name = loan.getName();
        this.amount = loan.getMaxAmount();
        this.payments = loan.getPayments();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }
}
