package com.vignesh.feesms.service;

import com.vignesh.feesms.DAO.FeePaymentRequest;
import com.vignesh.feesms.entity.Fee;
import com.vignesh.feesms.repository.FeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @PostConstruct
    private void initializeData() {
        // Insert sample data when the application starts
        Fee fee1 = new Fee(1L, BigDecimal.valueOf(500), new Date());
        Fee fee2 = new Fee(2L, BigDecimal.valueOf(750), new Date());
        Fee fee3 = new Fee(1L, BigDecimal.valueOf(600), new Date());

        feeRepository.saveAll(List.of(fee1, fee2, fee3));
    }
    public List<Fee> getFeeByStudent(Long studentId) {
        return feeRepository.findAllByStudentId(studentId);
    }

    public List<Fee> getFeesOfAll() {
        return feeRepository.findAll();
    }

    public Fee payFee(FeePaymentRequest paymentRequest) {
        Fee paidFee = new Fee(paymentRequest.getStudentId(),paymentRequest.getAmount(),new Date());
        return feeRepository.save(paidFee);
    }
}
