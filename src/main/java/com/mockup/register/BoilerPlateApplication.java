package com.mockup.register;

import com.mockup.register.sdk.model.AuditAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties
public class BoilerPlateApplication {

    public static void main(String[] args) {
		SpringApplication.run(BoilerPlateApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditAwareImpl();
    }
}
