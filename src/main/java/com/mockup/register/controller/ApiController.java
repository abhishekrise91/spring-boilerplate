package com.mockup.register.controller;

import com.mockup.register.common.exception.ErrorHandler;
import com.mockup.register.dto.AddApiDto;
import com.mockup.register.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping
    public void addApi(@Valid @RequestBody AddApiDto addApiDto,
                       BindingResult bindingResult) {
        log.info("addApi for endpoint {}", addApiDto.getEndpoint());
        ErrorHandler.handleBindingResult(bindingResult);
        apiService.addApi(addApiDto);
    }

    @GetMapping("/user")
    public String getUser() {
        return "abhishek";
    }
}
