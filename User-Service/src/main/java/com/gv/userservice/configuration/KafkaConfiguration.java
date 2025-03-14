package com.gv.userservice.configuration;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties(prefix = "aws.kafka")
@Validated
public class KafkaConfiguration {

    @NotEmpty
    private String accessKeyId;
    @NotEmpty
    private String secretAccessKey;
}
