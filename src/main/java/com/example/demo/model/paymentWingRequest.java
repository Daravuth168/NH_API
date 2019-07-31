package com.example.demo.model;

public class paymentWingRequest {
    String reference_number;
    String customer_name;
    String currency;
    String amount;
    String session_id;


    public paymentWingRequest(){};
    public paymentWingRequest(String reference_number, String customer_name, String currency, String amount, String session_id) {
        this.reference_number = reference_number;
        this.customer_name = customer_name;
        this.currency = currency;
        this.amount = amount;
        this.session_id = session_id;
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

    @Override
    public String toString() {
        return "paymentWingRequest{" +
                "reference_number='" + reference_number + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", session_id='" + session_id + '\'' +
                '}';
    }
}
