package com.mockup.register.converter;

import com.mockup.register.dto.AddApiDto;
import com.mockup.register.factory.ApiFactory;
import com.mockup.register.model.Api;
import com.mockup.register.sdk.converter.GenericConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiRequestConverter implements GenericConverter<AddApiDto, Api> {

    @Autowired
    private ApiFactory apiFactory;

    @Override
    public Api createFrom(AddApiDto addApiDto) {
        Api api = apiFactory.createApi();
        updateEntity(api, addApiDto);
        return api;
    }

    @Override
    public AddApiDto createFrom(Api entity) {
        return null;
    }

    @Override
    public Api updateEntity(Api api, AddApiDto addApiDto) {
        api.setEndpoint(addApiDto.getEndpoint());
        api.setResponseBody(addApiDto.getResponseBody());
        api.setResponseStatus(addApiDto.getResponseStatus());
        api.setResponseDelay(addApiDto.getResponseDelay());
        api.setResponseHeaders(addApiDto.getResponseHeaders());
        api.setAuthHeaderKey(addApiDto.getAuthHeaderKey());
        api.setAuthHeaderValue(addApiDto.getAuthHeaderValue());
        api.setProjectCode(addApiDto.getProjectCode());
        return api;
    }
}
