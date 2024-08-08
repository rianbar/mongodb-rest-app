package com.rian.MongoRest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String id;
    private String name;
    private String lastName;
    private int age;
}
