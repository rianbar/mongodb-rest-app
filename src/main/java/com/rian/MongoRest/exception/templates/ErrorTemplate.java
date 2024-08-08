package com.rian.MongoRest.exception.templates;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorTemplate {

    private int code;
    private String type;
    private String message;
}
