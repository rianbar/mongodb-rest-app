package com.rian.MongoRest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@Validated
public class CustomerDTO {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private int age;
}
