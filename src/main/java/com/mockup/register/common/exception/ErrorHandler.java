package com.mockup.register.common.exception;

import com.mockup.register.sdk.exception.WebException;
import com.mockup.register.sdk.util.DateUtil;
import org.springframework.validation.BindingResult;

import java.util.concurrent.atomic.AtomicReference;

public class ErrorHandler {

    public static void handleBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder message = new StringBuilder();

            AtomicReference<String> SEPARATOR = new AtomicReference<>("");
            bindingResult.getAllErrors().forEach(error -> {
                message.append(SEPARATOR.get()).append(error.getDefaultMessage());
                SEPARATOR.set(" | ");
            });

            throw new WebException(400, message.toString(), "", DateUtil.getNow());
        }
    }
}