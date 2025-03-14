package com.gv.userservice.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class WebClientConfig {
    @Value("${notification.orchestrator.service.url}")
    private String notificationOrchestratorServiceUrl;

    @Value("${web-client.configuration.service}")
    private String configurationServiceBaseUrl;
    @Value("${web-client.rule.service.url}")
    private String ruleEngineServiceBaseUrl;

    @Value("${web-client.branding.service.url}")
    private String brandingServiceBaseUrl;

    @Value("${web-client.mfa.service.url}")
    private String mfaUrl;

}