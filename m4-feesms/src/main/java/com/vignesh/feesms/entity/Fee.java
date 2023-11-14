package com.vignesh.feesms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private BigDecimal amount;
    private Date paymentDate;

    public Fee() {
    }

    public Fee( Long studentId, BigDecimal amount, Date paymentDate) {
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
