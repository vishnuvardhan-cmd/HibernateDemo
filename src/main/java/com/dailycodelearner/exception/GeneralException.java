package com.dailycodelearner.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralException {

    private String message;
    private HttpStatus code;
    private Throwable  cause;
}
