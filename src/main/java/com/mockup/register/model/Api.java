package com.mockup.register.model;

import com.mockup.register.repository.ApiRepository;
import com.mockup.register.sdk.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = ApiRepository.TABLE_NAME)
public class Api extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "response_body")
    private String responseBody;

    @Column(name = "response_status")
    private Integer responseStatus;

    @Column(name = "response_delay")
    private Integer responseDelay;

    @Column(name = "response_headers")
    private String responseHeaders;

    @Column(name = "auth_header_key")
    private String authHeaderKey;

    @Column(name = "authHeader_value")
    private String authHeaderValue;

    @Column(name = "endpoint_hash")
    private String endpointHash;

    @Column(name = "hit_count")
    private Integer hitCount;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "uuid")
    private String uuid;
}
