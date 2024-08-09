package com.rian.MongoRest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderModel {

    @MongoId
    private String id;
    private String title;
    private double price;
    private String additional;
    private CustomerModel customer;
}
