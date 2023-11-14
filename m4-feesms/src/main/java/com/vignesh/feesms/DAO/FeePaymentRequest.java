package com.vignesh.feesms.DAO;

import java.math.BigDecimal;

public class FeePaymentRequest {

    private Long studentId;
    private BigDecimal amount;

    public FeePaymentRequest() {
    }

    public FeePaymentRequest(Long studentId, BigDecimal amount) {
        this.studentId = studentId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FeePaymentRequest{" +
                "studentId=" + studentId +
                ", amount=" + amount +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
