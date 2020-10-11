package com.mockup.register.sdk.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorBody {
    private Date timestamp;
    private String message;
    private String errorCode;

    public ErrorBody(WebException webException) {
        this.timestamp = webException.getTimestamp();
        this.message = webException.getMessage();
        this.errorCode = webException.getErrorCode();
    }

    public ErrorBody(Date date, String message) {
        this.timestamp = date;
        this.message = message;
    }
}