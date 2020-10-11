package com.mockup.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mockup.register.sdk.model.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddApiDto extends AbstractDto {

    @NotEmpty(message = "endpoint cannot be empty")
    @JsonProperty("endpoint")
    private String endpoint;

    @JsonProperty("responseBody")
    private String responseBody;

    @JsonProperty("responseStatus")
    private Integer responseStatus;

    @JsonProperty("responseDelay")
    private Integer responseDelay;

    @JsonProperty("responseHeaders")
    private String responseHeaders;

    @JsonProperty("authHeaderKey")
    private String authHeaderKey;

    @JsonProperty("authHeaderValue")
    private String authHeaderValue;

    @JsonProperty("newProject")
    private Boolean newProject;

    @JsonProperty("projectCode")
    private String projectCode;
}
