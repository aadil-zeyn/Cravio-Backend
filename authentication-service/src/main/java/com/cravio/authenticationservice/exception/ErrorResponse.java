package com.cravio.authenticationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private String message;
    private List<String> errors;
}
