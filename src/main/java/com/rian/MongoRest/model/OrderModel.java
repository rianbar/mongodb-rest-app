package com.rian.MongoRest.model;

import com.rian.MongoRest.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class OrderModel {

    @MongoId
    private String id;
    private String title;
    private double price;
    private String additional;
    private CustomerDTO customer;
}
