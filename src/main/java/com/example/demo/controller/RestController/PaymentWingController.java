package com.example.demo.controller.RestController;

import com.example.demo.controller.ContextParser;
import com.example.demo.model.paymentWingCommit;
import com.example.demo.model.paymentWingRequest;
import com.example.demo.repositories.PaymentWingRepository;
import com.example.demo.services.PaymentWingService;
import io.micrometer.core.instrument.util.JsonUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class PaymentWingController {

    @Autowired
    private PaymentWingRepository paymentWingRepository;
    @Autowired
    private PaymentWingService paymentWingService;


    @GetMapping("/GetAccountPaymentWing/{accountNumber}/{Amount}/{Currency}")
    @ResponseBody
    @ApiOperation(value = "Response Amount to Wing")
    public ResponseEntity<Map<String, Object>> get(@PathVariable("accountNumber") String accountnumber,@PathVariable("Amount") String Amount,@PathVariable("Currency") String Currency) {
        int digit =Amount.toString().indexOf('.');
        double digitAmount =Double.parseDouble(Amount.toString());
        Map<String, Object> response = new HashMap<>();
        List<paymentWingRequest> paymentWingRequests = this.paymentWingService.getAccountPayment(accountnumber);
        //ContextParser contextParser=new ContextParser();
        //paymentWingRequests.get(0).setAmount(contextParser.encrypt(paymentWingRequests.get(0).getAmount()));
        if (Currency.equals("USD") && (Amount.length() - digit -1)>2 && digit >0) {
            response.put("response_msg", "USD allow 2 digit decimal");
            return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        else if ((Currency.equals("KHR") && (Amount.length() - digit -1)>0 && (digitAmount%1)>0) || (Currency.equals("KHR") && (Amount.length() - digit -1)>0 &&(digitAmount%100)>0)) {

            response.put("response_msg", "KHR not allow This Amount and Check Amount Again");
            return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

       else if (paymentWingRequests.isEmpty()) {
           //response.put("response_msg", "Can not find");
           //response.put("response_code", "400");
            return new ResponseEntity("Can not find", HttpStatus.NOT_FOUND);
                    //ResponseEntity.ok(response);

        }
        else if (!Currency.equals(paymentWingRequests.get(0).getCurrency())) {
            response.put("response_msg", "Wrong Currency Payment");
            return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
        }
        else {

            response.put("data", paymentWingRequests);
            response.put("response_msg", "Transaction Success");
            response.put("response_code","200");
            return ResponseEntity.ok(response);
        }

    }

    @PostMapping("/CommitPaymentWing")
    @ApiOperation(value = "Commit Transaction from Wing")
    public ResponseEntity<Map<String, Object>>  savePaymentWing(@RequestBody paymentWingCommit paymentWingCommit){
         int digit =paymentWingCommit.getAmount().toString().indexOf('.');
         double digitAmount =Double.parseDouble(paymentWingCommit.getAmount().toString());
        Map<String, Object> response = new HashMap<>();
        ContextParser contextParser=new ContextParser();

        if (paymentWingCommit.getCurrency().equals("USD") && (paymentWingCommit.getAmount().length() - digit -1)>2 && digit >0) {
            response.put("response_msg", "USD allow 2 digit decimal");
            return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
        }
        else if ((paymentWingCommit.getCurrency().equals("KHR") && (paymentWingCommit.getAmount().length() - digit -1)>0 && (digitAmount%1)>0) || (paymentWingCommit.getCurrency().equals("KHR") && (paymentWingCommit.getAmount().length() - digit -1)>0 &&(digitAmount%100)>0)) {

            response.put("response_msg", "KHR not allow decimal and Check Amount Again");
            return new ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED);
        }
        else {

            if (this.paymentWingService.savePaymentWing(paymentWingCommit)) {

                response.put("data", paymentWingCommit);
                response.put("response_msg", "Transaction Success");
                response.put("response_code", "200");
                return ResponseEntity.ok(response);

            } else {
                response.put("response_msg", "Transaction Error");
                response.put("response_code", "400");
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            }
        }
    }

}
