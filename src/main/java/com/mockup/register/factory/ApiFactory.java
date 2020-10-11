package com.mockup.register.factory;

import com.mockup.register.model.Api;
import com.mockup.register.sdk.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiFactory {

    public Api createApi() {
        Api api = new Api();
        api.setHitCount(0);
        api.setResponseStatus(200);
        api.setUuid(StringUtil.getUuid());
        return api;
    }
}
