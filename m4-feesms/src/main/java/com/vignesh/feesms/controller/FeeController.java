package com.vignesh.feesms.controller;

import com.vignesh.feesms.DAO.FeePaymentRequest;
import com.vignesh.feesms.entity.Fee;
import com.vignesh.feesms.service.FeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @GetMapping
    public ResponseEntity<List<Fee>> getFeesOfAll(){
        List<Fee> fee = feeService.getFeesOfAll();
        return ResponseEntity.ok(fee);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Fee>> getFeesByStudent(@PathVariable Long studentId){
        List<Fee> fees = feeService.getFeeByStudent(studentId);
        return ResponseEntity.ok(fees);
    }

    @PostMapping("/pay")
    public ResponseEntity<Fee> payFee(@RequestBody FeePaymentRequest paymentRequest){
        Fee paidFee = feeService.payFee(paymentRequest);
        return ResponseEntity.ok(paidFee);
    }

}
