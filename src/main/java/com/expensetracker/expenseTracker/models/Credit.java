package com.expensetracker.expenseTracker.models;


import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;


@Data
@Entity
public class Credit {
    
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    private double amount;

    private String lender;

    private Date repaymentDate;

    @Column(columnDefinition = "TEXT")
    private String note;

}
