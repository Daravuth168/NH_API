package com.example.demo.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class paymentWingCommit {

    String reference_number;
    String customer_name;
    String currency;
    String amount;
    String session_id;
    String transaction_id;



    public paymentWingCommit() {
    }

    public paymentWingCommit(String reference_number, String customer_name, String currency, String amount, String session_id, String transaction_id) {
        this.reference_number = reference_number;
        this.customer_name = customer_name;
        this.currency = currency;
        this.amount = amount;
        this.session_id = session_id;
        this.transaction_id = transaction_id;
    }

    public String getReference_number() {
        return reference_number;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public String toString() {
        return "paymentWingCommit{" +
                "reference_number='" + reference_number + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", session_id='" + session_id + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
