package com.example.catsgram.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncorrectParameterException extends RuntimeException {
    private String parameter;

    public IncorrectParameterException(String parameter) {
        super();

        this.parameter = parameter;
    }

    public IncorrectParameterException(String message, String parameter) {
        super(message);

        this.parameter = parameter;
    }
}
