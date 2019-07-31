package com.example.demo.services.impl;

import com.example.demo.model.paymentWingCommit;
import com.example.demo.model.paymentWingRequest;
import com.example.demo.repositories.PaymentWingRepository;
import com.example.demo.services.PaymentWingService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.util.List;

@Service
public class PaymentWingImpl implements PaymentWingService {

    @Autowired
    private PaymentWingRepository paymentWingRepository;


    @Override
    public List<paymentWingRequest> getAccountPayment(String accountNumber) {
        return this.paymentWingRepository.getAccountPaymentWing(accountNumber);
    }

    @Override
    public boolean savePaymentWing(paymentWingCommit paymentWingCommit) {
        return this.paymentWingRepository.savePaymentWing(paymentWingCommit);
    }
}
