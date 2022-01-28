package com.expensetracker.expenseTracker.models;


import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Expense {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    @Min(0)
    private double amount;

    @NotNull
    @NotBlank
    private String reason;

    private String location;

    @NotNull
    @NotBlank
    @JsonProperty("payment_method")
    private String paymentMethod;

    @Column(columnDefinition = "TEXT")
    private String description;
    
}
