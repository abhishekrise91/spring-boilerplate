package com.mockup.register.sdk.exception;

public class ExceptionHelper {

    public static WebException throwWebException(IErrorCode errorCode) {
        throw WebException.builder()
                .errorCode(errorCode.getCode())
                .message(errorCode.getMessage())
                .statusCode(errorCode.getStatusCode())
                .build();
    }
}
