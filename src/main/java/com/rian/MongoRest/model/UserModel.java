package com.rian.MongoRest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @MongoId
    private String id;
    private String name;
    private String lastName;
    private int age;
}
