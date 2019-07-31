package com.example.demo.repositories;

import com.example.demo.model.paymentWingCommit;
import com.example.demo.model.paymentWingRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentWingRepository {

    @Select("exec [dbo].[SM_P_APIPaymentWingRequest] #{accountNumber}")
    List<paymentWingRequest> getAccountPaymentWing(String accountNumber);

    @Insert("Insert into APIPaymentWing values(#{session_id},#{reference_number},#{transaction_id}" +
            ",#{customer_name},#{amount},#{currency},getdate())")
    @Options(useGeneratedKeys = true)
    boolean savePaymentWing(paymentWingCommit paymentWingCommit);

}
