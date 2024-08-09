package com.rian.MongoRest.dto;

import com.rian.MongoRest.model.CustomerModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class OrderDTO {
    private String id;
    @NotBlank
    private String title;
    @NotBlank
    private double price;
    @NotNull
    private String additional;
    private CustomerModel customer;
}
