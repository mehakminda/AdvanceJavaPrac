package com.learning.telusko.question1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;
}
