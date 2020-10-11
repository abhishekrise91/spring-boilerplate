package com.mockup.register.repository;

import com.mockup.register.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Api, Long> {
    // This is a constant, so variable name is in upper case.
    String TABLE_NAME = "m_api";
}
