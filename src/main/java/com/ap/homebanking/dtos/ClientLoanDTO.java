package com.ap.homebanking.dtos;

import com.ap.homebanking.models.ClientLoan;

public class ClientLoanDTO {
    private long id;
    private long LoanId;
    private String name;
    private double amount;
    private int payments;

    public ClientLoanDTO() {
    }

    public ClientLoanDTO(ClientLoan clientLoan) {
        this.id = clientLoan.getId();
        this.LoanId = clientLoan.getLoan().getId();
        this.name = clientLoan.getLoan().getName();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoanId() {
        return LoanId;
    }

    public void setLoanId(long loanId) {
        LoanId = loanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}


