package com.example.demo.services;

import com.example.demo.model.paymentWingCommit;
import com.example.demo.model.paymentWingRequest;

import java.util.List;

public interface PaymentWingService {
    List<paymentWingRequest> getAccountPayment(String accountNumber);

    boolean savePaymentWing(paymentWingCommit paymentWingCommit);


}
