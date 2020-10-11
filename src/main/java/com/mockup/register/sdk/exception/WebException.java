package com.mockup.register.sdk.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebException extends RuntimeException {

    private int statusCode;
    private String message;
    private String errorCode;
    private Date timestamp;
}