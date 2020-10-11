package com.mockup.register.service;

import com.mockup.register.converter.ApiRequestConverter;
import com.mockup.register.dto.AddApiDto;
import com.mockup.register.model.Api;
import com.mockup.register.repository.ApiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiService {

    @Autowired
    private ApiRequestConverter apiRequestConverter;

    @Autowired
    private ApiRepository apiRepository;

    public void addApi(AddApiDto addApiDto) {
        Api api = apiRequestConverter.createFrom(addApiDto);
        apiRepository.save(api);
    }
}
